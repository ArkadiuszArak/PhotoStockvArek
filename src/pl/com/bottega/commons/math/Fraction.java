package pl.com.bottega.commons.math;

/**
 * Created by arkadiuszarak on 19/03/2016.
 */
public class Fraction {
    // stala pole statyczne  (pole kalsy a nie obiektu klasy)
    public static final Fraction ONE = new Fraction(1,1);
    public static final Fraction ZERO = new Fraction(0,1);

    private final int nominator;
    private final int denominator;


    /**
     * Klasa modelujaca ulamek
     *
     * @param nominator licznik ulamka
     * @param denominator - mianownik ulamka
     *
     * @throws IllegalArgumentException gdy mianownik = 0
     */
    public Fraction(int nominator, int denominator) throws IllegalArgumentException {
        if(denominator == 0)
            throw new IllegalArgumentException("Denominator can not be zero");

        this.nominator = nominator;
        this.denominator = denominator;

    }

    public Fraction(int nominator){
        this.nominator = nominator;
        this.denominator = 10;
    }

    /**
     *
     * @param iteral ulamek w reprezentacji licznik/mianownik np. 3/4
     */
    public Fraction(String iteral) throws IllegalArgumentException, NumberFormatException{
        String[] parts = iteral.split("/");
        if(parts.length != 2)
            throw new IllegalArgumentException("To nie jest ulamek");

        try {
            this.nominator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);

            if(this.denominator == 0)
                throw new IllegalArgumentException("Zero w mianowniku jest zabronioe");
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException("To nie jest ulamek ", ex);
        }
    }

    public Fraction add(Fraction addend) {
        if(this.denominator == addend.denominator){
            int nominatorSum = this.nominator + addend.nominator;
            return new Fraction(nominatorSum, this.denominator); //jest typ Fraction dlatego musi taki zwrocic
        }
        else{
            int thisNominator = this.nominator * addend.denominator;
            int addentDenominator = addend.nominator * this.denominator;
            int commonDenominator = this.denominator * addend.denominator;

            return new Fraction(thisNominator + addentDenominator, commonDenominator);
        }
    }
    public String toString() {
        //return nominator + " / " + denominator;
        int modulo = nominator % denominator;
        int wholeNumber = nominator / denominator;

        if(modulo == 0) {
            return line(wholeNumber);

        }
        else if (wholeNumber == 0){
            return spacesForNominatorWhenNoWholeNumbere(denominator) + line(nominator) + "\n" +
                    dash(denominator) + "\n" +
                    line(denominator);
        }
        else {
            return spaces(wholeNumber) + line(modulo) + "\n" +
                    line(wholeNumber) + dash(denominator) + "\n" +
                    spaces(wholeNumber) + line(denominator);
        }
    }

    private String line(int number){

        return String.valueOf(number);
    }

    private String spaces(int spaceLength){
        StringBuffer outputBuffer = new StringBuffer(spaceLength);
        int length = String.valueOf(spaceLength).length();
        for (int i = 0; i < length; i++){
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    private String dash(int dashLength){
        StringBuffer outputBuffer = new StringBuffer(dashLength);
        int length = String.valueOf(dashLength).length();
        for (int i = 0; i < length; i++){
            outputBuffer.append("-");
        }
        return outputBuffer.toString();
    }

    private String spacesForNominatorWhenNoWholeNumbere(int spaceLength){
        StringBuffer outputBuffer = new StringBuffer(spaceLength);
        int length = String.valueOf(spaceLength).length() / 2;
        for (int i = 0; i < length; i++){
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    public Fraction reverse() throws IllegalStateException{
        try{
            return new Fraction(this.denominator, this.nominator);
        } catch (IllegalArgumentException ex){
            throw new IllegalStateException("Zero can not be reversed ", ex);
        }
    }

    public Fraction reverse2() throws IllegalStateException {
        if (nominator == 0)
            throw new IllegalStateException("Can no reverese zero");
        return new Fraction(denominator, nominator);
    }
}