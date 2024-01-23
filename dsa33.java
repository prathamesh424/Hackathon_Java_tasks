
import java.util.Scanner;


// 1] Use OOP for creating class with constructor,  getters and setters and invoke that methods from other class.
class rectagle{
    double length;
    double bredth;

    rectagle(double l , double b ) {
        System.out.println( "class rectangle ");   
    }
    public void setlength(double l ){
        this.length =l;
    }
     public double getlength( ){
        return length;
    }

     public void setbredth(double b ){
        this.bredth =b;
    }
     public double getbredth( ){
        return  bredth;
        
    }
    public double area(){
        return length *bredth;
    }
} 

    // ans :-

/*public class dsa33 {

    public static void main(String[] args) {

        rectagle  obj = new rectagle(0, 0) ;
        obj.setbredth(10.5);
        obj.setlength(8.9);
        double l = obj.getlength() ;
        double b = obj.getbredth() ;
        System.out.printf("length :- " + l   + "bredth :-"  + b + "\n" );
        double area = obj.area() ;
        System.out.printf("Area is : -" +  area);
    }
}*/





//   2]write code for hybrid inheritance : -
class A {
    void display1() {
        System.out.println("Inside class A");
    }
}

class B extends A {
    void display1() {
        System.out.println("Inside class B");
        super.display1();
    }
}

interface C {
    void display();
}

class D extends B  implements C {
    @Override
    public
    void display() {
        super.display1();
        System.out.println("in class D ");
    }
}

/*public class dsa33 {
    public static void main(String[] args) {
         D  obj = new D() ;
         obj.display();
    }
}*/




// 3]write a code for interface and  implement it :

interface basicAnimal {
    void eat();
    void sleep();

}

class monkey {
  public  void jump(){
        System.out.println( "Jumping ....");
    }
   public void bite (){
    System.out.println( "biting ...");
   }
}

class Human extends monkey implements basicAnimal{
    public void speak (){
        System.out.println( "speaking :- Hello Sir !!"  );
    }

    public void eat (){
        System.out.println("Can eat both meat and vegitables ");
    }

    public void sleep (){
        System.out.println( "sleeping ");            
    }

}

        //ans : -
/*public class dsa33 {
    public static void main(String[] args) {
        Human h = new Human();
                    h.bite();
                    h.eat();
                    h.jump();
                    h.speak();
                    h.sleep();
                    //introduction of polymorphism
                    monkey m = new Human();
                    m.jump();
                  //  m.sleep();      ...error 
                  m.bite();
                 // m.speak();        ...error 
  
                    
                    basicAnimal a = new Human();
                    a.sleep();
                    a.eat();
                  //  a.speak();    ....error

    }
}*/


    
    


  // 4]write code for all three uses for super keyword : - 


        // i ] Accessing parent class variables 
        class Vehicle { 
            int maxSpeed = 120; 
        } 

        class Car extends Vehicle { 
            int maxSpeed = 180; 
          
            void display(){ 
                System.out.println("Maximum Speed: "+ super.maxSpeed); 
            } 
        } 

        /*class dsa33 { 
            public static void main(String[] args) 
            { 
                Car c = new Car(); 
                c.display(); 
            } 
        } */




        // ii] Invoking parent class methods
        class Person { 
            void message()  {
		        System.out.println("This is person class \n"); 
	            } 
            } 
        class Student extends Person { 
	        void message(){ 
		        System.out.println("This is student class"); 
	            } 

	        void display(){ 
		        message(); 
		        super.message(); } 
                } 

            /*class dsa33 { 
                public static void main(String args[]){ 
		            Student s = new Student(); 
                    s.display(); 
	            } 	
            } */


        //iii] Invoking parent class constructors :-


        class animal { 
                animal(){ 
                System.out.println("animal class Constructor"); 
                } 
            } 
        class dog extends animal { 
                dog(){ 
                    super(); 
                    System.out.println("dog class Constructor"); 
                } 
            } 
       /*  class dsa33 { 
            public static void main(String[] args){ 
                dog s = new dog(); 
            } 
        } */
                
                



        // 5] Print the sum, difference and product of two complex numbers by creating aclass named 'Complex' with separate methods for each operation whose real and imaginary
        // parts are entered by the user


        class Complex{
            int real;
            int imag;
            public Complex(int r, int i){
                real = r;
                imag = i;
            }
            public static Complex add(Complex a, Complex b){
                return new Complex((a.real+b.real),(a.imag+b.imag));
            }
            public static Complex diff(Complex a, Complex b){
                return new Complex((a.real-b.real),(a.imag-b.imag));
            }
            public static Complex product(Complex a, Complex b){
                return new Complex(((a.real*b.real)-(a.imag*b.imag)),((a.real*b.imag)+(a.imag*b.real)));
            }
            public void printComplex(){
                if(real == 0 && imag!=0){
                    System.out.println(imag+"i");
                }
                else if(imag == 0 && real!=0){
                    System.out.println(real);
                }
                else{
                    System.out.println(real+"+"+imag+"i");
                }
            }
        }
        public class dsa33 {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter real part of complex number 1: ");
                int real1 = sc.nextInt();
                System.out.println("Enter complex part of complex number 1 without iota sign:");
                int comp1 = sc.nextInt();
                System.out.println("Enter real part of complex number 2: ");
                int real2 = sc.nextInt();
                System.out.println("Enter complex part of complex number 2 without iota sign: ");
                int comp2 = sc.nextInt();
                Complex a = new Complex(real1, comp1);
                Complex b = new Complex(real2, comp2);
                Complex e = Complex.add(a, b);
                Complex f = Complex.diff(a, b);
                Complex g = Complex.product(a, b);
                e.printComplex();
                f.printComplex();
                g.printComplex();
            }
        }





