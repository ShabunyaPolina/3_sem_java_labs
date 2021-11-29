package by.bsu.shabunya.newyeargift.program;

import by.bsu.shabunya.newyeargift.gift.NewYearGift;
import by.bsu.shabunya.newyeargift.sweets.*;

public class Program {
    public static void main(String[] args) {

        NewYearGift gift = new NewYearGift();
        gift.addSweet(new ChocolateBar("Milka choco", 100, 20));
        gift.addSweet(new ChocolateCandy("Twix", 30, 5));
        gift.addSweet(new ChocolateCookie("ChocoPie", 60, 9));
        gift.addSweet(new Cookie("HoneyCookie", 60, 7));
        gift.addSweet(new Halva("EgyptHalva", 90,10));
        gift.addSweet(new Lollipop("ChupaChups", 45, 10));
        gift.addSweet(new Waffle("Yummy", 130, 14));

        System.out.println(gift.getSweets());

        System.out.println("Weight of gift: " + gift.calculateWeight());

        gift.sortSweetsByWeight();
        System.out.println("Sorted by weight: " + gift.getSweets());
        gift.sortSweetsBySugarWeight();
        System.out.println("Sorted by sugar weight: " + gift.getSweets());

        System.out.println("Sugar 8-10 g: " + gift.findSweets(8,10));
        System.out.println("Sugar 30-50 g: " + gift.findSweets(30,50));
    }
}
