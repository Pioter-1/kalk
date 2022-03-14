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
        
        
        // skracanie u�amka
        licznik = licznik / nwd;
        mianownik = mianownik / nwd;

        this.calkowita = calkowita;
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public Fraction(int licznik, int mianownik) {
        int nwd = nwd(licznik, mianownik);

        // skracanie u�amka
        licznik = licznik / nwd;
        mianownik = mianownik / nwd;

        if (licznik == mianownik) { // gdy licznik i mianownik s� r�wne, wynik = 1
            this.calkowita = 1;
            this.licznik = 0;
            this.mianownik = 1;
        } else if (licznik > mianownik) { // u�amek niew�a�ciwy, wyci�gaie cz�ci ca�kowitej
            this.calkowita = licznik / mianownik;
            this.licznik = licznik % mianownik;
            this.mianownik = mianownik;
        } else { // u�amek w�a�ciwy
            this.calkowita = 0;
            this.licznik = licznik;
            this.mianownik = mianownik;
        }
    }

    public double getFractionAsDecimal() {
        return calkowita + (double) licznik / mianownik;
    }

    public String getFractionAsString() {
        if (mianownik == 1) { // je�li mianownik = 1, w klasie powinna byc liczba ca�kowita
            return String.valueOf(calkowita);
        } else if (calkowita == 0) { // brak cz�ci ca�kowitej zwracany jest sam u�amek
            return licznik + "/" + mianownik;
        } else { // je�li jest cz�� ca�kowita to zwracamy jako liczb� mieszan�
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

    public Fraction mno�enie(Fraction fraction) {
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

    //Najwi�kszy wsp�lny dzielnik
    
   public static int nwd(int a, int b) {
       if (a < 0) a = -a; // zmieniamy na warto�ci dodatnie
       if (b < 0) b = -b;

       while (a != b)
           if (a > b) a -= b;
           else b -= a;

       return a;
   }

 
}