class Fraction {
    private int numerator;
    private  int denominator;

    public Fraction (int numerator, int denominator){
        // try catch if denominator is zero
        if (denominator == 0){
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        if (denominator < 0 ){
            this.denominator = denominator * -1;
            this.numerator = numerator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator (){
        System.out.println(numerator);
        return numerator;
    }
    public  int getDenominator(){
        System.out.println(denominator);
        return denominator;
    }
    public String toString(){
        String num = String.valueOf(numerator);
        String den =  Integer.toString(denominator);
        return num+"/"+den;
    }
    public double toDouble(){
        double num = (double)(numerator);
        double den =  (double)(denominator);
        return num/den;
    }
    public Fraction add(Fraction other){
           Fraction res = new Fraction(other.numerator, other.denominator);
           int gcd = gcd(res.denominator, this.denominator);


           if(gcd == res.denominator){
               res.numerator = res.numerator + this.numerator*(gcd/this.denominator);
           } else if (gcd == this.denominator){
               res.numerator = res.numerator*(gcd/res.denominator) + this.numerator;
           } else {
               res.numerator = (res.numerator * this.denominator) + (this.numerator* res.denominator);
           }
           res.denominator = gcd;
                 res.toLowestTerms();
           System.out.println(numerator + "/" +denominator + " + "+ other.numerator+"/"+other.denominator +   " = " + res.numerator+"/"+res.denominator);

           return res;
    }


    public Fraction subtract (Fraction other){
        Fraction res = new Fraction(other.numerator, other.denominator);
        int gcd = gcd(res.denominator, this.denominator);


        if(gcd == res.denominator){
            res.numerator =  this.numerator*(gcd/this.denominator) - res.numerator;
        } else if (gcd == this.denominator){
            res.numerator =  this.numerator-res.numerator*(gcd/res.denominator);
        } else {
            res.numerator =  (this.numerator* res.denominator)-(res.numerator * this.denominator);
        }
        res.denominator = gcd;

        System.out.println(numerator + "/" +denominator + " - "+ other.numerator+"/"+other.denominator +   " = " + res.numerator+"/"+res.denominator);
        return res;
    }


    public Fraction multipy(Fraction other){
        Fraction res = new Fraction(other.numerator, other.denominator);



        res.numerator = this.numerator* other.numerator;
        res.denominator = this.denominator* other.denominator;

        System.out.println(numerator + "/" +denominator + " * "+ other.numerator+"/"+other.denominator +   " = " + res.numerator+"/"+res.denominator);

        return res;
    }


    public Fraction divide(Fraction other){
        Fraction res = new Fraction(other.numerator, other.denominator);



        res.numerator = this.numerator * other.denominator;
        res.denominator = this.denominator * other.numerator;

        System.out.println(numerator + "/" +denominator + " / "+ other.numerator+"/"+other.denominator +   " = " + res.numerator+"/"+res.denominator);

        return res;
    }

        public boolean equals(Object obj) {
            if(this == obj)
               return true;
            if(obj == null || obj.getClass()!= this.getClass())
                return false;
            Fraction other = (Fraction) obj;
            return (other.toDouble() == this.toDouble());
        }

    public void toLowestTerms(){
             int gcf = gcf(this.numerator,this.denominator);
             this.numerator = this.numerator / gcf;
             this.denominator = this.denominator / gcf;
    }
    public static int gcd(int num1, int num2){
           int num = num1;
          if(num > num2){
              if(num % num2 == 0){
                     num = num;
              } else {
                  num =  num * num2;
              }
          } else if (num2 > num){
              if(num2%num==0){
                  num = num2;
              } else {
                  num =  num2 * num;
              }
          }
                System.out.println("Greatest common denominator of given numbers is: "+ num);
            
          
              return num;
    }

    public static int gcf(int num1, int num){
           int num2 = num;
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        System.out.println("Greatest common factor of given numbers is: "+ num2);
        return num2;
        }
}
