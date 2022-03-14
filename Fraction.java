public class Fraction {

    private int calkowita;
    private int licznik;
    private int mianownik;

    public Fraction(int value) {
        calkowita = value;
        licznik = 0;
        mianownik = 1;
    }

    public Fraction(int calkowita, int licznik, int mianownik) {
        

        int nwd = nwd(licznik, mianownik);
        
        
        // skracanie u³amka
        licznik = licznik / nwd;
        mianownik = mianownik / nwd;

        this.calkowita = calkowita;
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public Fraction(int licznik, int mianownik) {
        int nwd = nwd(licznik, mianownik);

        // skracanie u³amka
        licznik = licznik / nwd;
        mianownik = mianownik / nwd;

        if (licznik == mianownik) { // gdy licznik i mianownik s¹ równe, wynik = 1
            this.calkowita = 1;
            this.licznik = 0;
            this.mianownik = 1;
        } else if (licznik > mianownik) { // u³amek niew³aœciwy, wyci¹gaie czêœci ca³kowitej
            this.calkowita = licznik / mianownik;
            this.licznik = licznik % mianownik;
            this.mianownik = mianownik;
        } else { // u³amek w³aœciwy
            this.calkowita = 0;
            this.licznik = licznik;
            this.mianownik = mianownik;
        }
    }

    public double getFractionAsDecimal() {
        return calkowita + (double) licznik / mianownik;
    }

    public String getFractionAsString() {
        if (mianownik == 1) { // jeœli mianownik = 1, w klasie powinna byc liczba ca³kowita
            return String.valueOf(calkowita);
        } else if (calkowita == 0) { // brak czêœci ca³kowitej zwracany jest sam u³amek
            return licznik + "/" + mianownik;
        } else { // jeœli jest czêœæ ca³kowita to zwracamy jako liczbê mieszan¹
            return calkowita + " " + licznik + "/" + mianownik;
        }
    }

    public Fraction dodawnanie(Fraction fraction) {
        int n1 = this.licznik + this.calkowita * this.mianownik;
        int d1 = this.mianownik;
        int n2 = fraction.licznik + fraction.calkowita * fraction.mianownik;
        int d2 = fraction.mianownik;
        return new Fraction(n1 * d2 + n2 * d1, d1 * d2);
    }

    public Fraction odejmowanie(Fraction fraction) {
        int n1 = this.licznik + this.calkowita * this.mianownik;
        int d1 = this.mianownik;
        int n2 = fraction.licznik + fraction.calkowita * fraction.mianownik;
        int d2 = fraction.mianownik;
        return new Fraction(n1 * d2 - n2 * d1, d1 * d2);
    }

    public Fraction mno¿enie(Fraction fraction) {
        int n1 = this.licznik + this.calkowita * this.mianownik;
        int d1 = this.mianownik;
        int n2 = fraction.licznik + fraction.calkowita * fraction.mianownik;
        int d2 = fraction.mianownik;
        return new Fraction(n1 * n2, d1 * d2);
    }

    public Fraction dzielenie(Fraction fraction) {
        int n1 = this.licznik + this.calkowita * this.mianownik;
        int d1 = this.mianownik;
        int n2 = fraction.licznik + fraction.calkowita * fraction.mianownik;
        int d2 = fraction.mianownik;
        return new Fraction(n1 * d2, d1 * n2);
    }

    //Najwiêkszy wspólny dzielnik
    
   public static int nwd(int a, int b) {
       if (a < 0) a = -a; // zmieniamy na wartoœci dodatnie
       if (b < 0) b = -b;

       while (a != b)
           if (a > b) a -= b;
           else b -= a;

       return a;
   }

 
}