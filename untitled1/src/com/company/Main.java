package com.company;
import java.util.Scanner;
class Fractions {
    private int denominator;
    private int numerator;

    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static int algoritm(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static int NOK(int a, int b) {
        return a * b / algoritm(a, b);
    }

    public static Fractions summa(Fractions a, Fractions b) {
        int denominator = NOK(a.denominator, b.denominator);
        int numerator = a.numerator * (denominator / a.denominator) + b.numerator * (denominator / b.denominator);
        int LNOK = algoritm(denominator, numerator);
        denominator = denominator / LNOK;
        numerator = numerator / LNOK;
        Fractions c = new Fractions(numerator, denominator);
        return c;
    }

    public static Fractions raznost(Fractions a, Fractions b) {
        int denominator = NOK(a.denominator, b.denominator);
        int numerator = a.numerator * (denominator / a.denominator) - b.numerator * (denominator / b.denominator);
        int LNOK = algoritm(denominator, numerator);
        denominator = denominator / LNOK;
        numerator = numerator / LNOK;
        Fractions z = new Fractions(numerator, denominator);
        return z;
    }

    public static Fractions umnozhenie(Fractions a, Fractions b) {
        int denominator = a.denominator * b.denominator;
        int numerator = a.numerator * b.numerator;
        int LNOK = algoritm(denominator, numerator);
        denominator = denominator / LNOK;
        numerator = numerator / LNOK;
        Fractions v = new Fractions(numerator, denominator);
        return v;
    }

    public static Fractions delenie(Fractions a, Fractions b) {
        int denominator = a.denominator * b.numerator;
        int numerator = a.numerator * b.denominator;
        int largestMultiple = algoritm(denominator, numerator);
        denominator = denominator / largestMultiple;
        numerator = numerator / largestMultiple;
        Fractions c = new Fractions(numerator, denominator);
        return c;
    }

    public String toString() {
        return numerator + "/" + denominator + "\n" + "numerator =" + numerator + ", denominator =" + denominator;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите числитель первой дроби: ");
        int numerator1 = input.nextInt();
        System.out.println("Введите знаменатель первой дроби: ");
        int denominator1 = input.nextInt();
        System.out.println("Введите числитель второй дроби: ");
        int numerator2 = input.nextInt();
        System.out.println("Введите знаменатель второй дроби:: ");
        int denominator2 = input.nextInt();


            Fractions fraction1 = new Fractions(numerator1, denominator1);
            Fractions fraction2 = new Fractions(numerator2, denominator2);

            System.out.println("Сумма: ");
            System.out.println(Fractions.summa(fraction1, fraction2));
            System.out.println("Разность: ");
            System.out.println(Fractions.raznost(fraction1, fraction2));
            System.out.println("Произведение: ");
            System.out.println(Fractions.umnozhenie(fraction1, fraction2));
            System.out.println("Частное: ");
            System.out.println(Fractions.delenie(fraction1, fraction2));
    }
}
