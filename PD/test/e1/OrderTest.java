package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    static Order order = new Order(1111);
    static Order order2 = new Order(2222);
    static Order order3 = new Order(3333);
    @BeforeAll
    static void addExamples(){
        order.setStock("111",12);
        order.setStock("222",2);
        order.setStock("333",3);
        order.setStock("444",20);
        order2.setStock("111",12);
        order2.setStock("222",2);
        order2.setStock("333",3);
        order2.setStock("444",20);
        order3.setStock("111",12);
        order3.setStock("222",2);
        order3.setStock("333",3);
        order3.setStock("444",20);
    }
    @Test
    void pdfExample(){
        order2.shopping();
        assertEquals("{111=12, 222=2, 333=3, 444=20}",order2.getStock().toString());
        order2.addProduct("111",10);
        order2.addProduct("222",2);
        order2.addProduct("333",3);
        order2.addProduct("444",4);
        order2.removeProduct("444");
        order2.addProduct("444",5);
        order2.checkout();
        order2.manageProduct("111",1);
        assertEquals("{111=1, 222=0, 333=0, 444=15}",order2.getStock().toString());
        order2.payment();
        order2.cancel("2023-11-12 12:01:01");
        order2.showLog();
    }
    @Test
    void extendedVersion(){
        order.screenInfo();
        assertThrows(IllegalStateException.class, () ->order.addProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.manageProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.removeProduct("111"));
        assertThrows(IllegalStateException.class, () -> order.payment());
        assertThrows(IllegalStateException.class, () -> order.checkout());
        assertThrows(IllegalStateException.class, () -> order.cancel("2022-12-12 12:01:01"));
        assertThrows(IllegalStateException.class, () -> order.complete("2022-12-12 12:01:01"));
        order.shopping();
        order.shopping();
        order.checkout();
        order.screenInfo();
        assertThrows(IllegalStateException.class, () -> order.payment());
        assertThrows(IllegalStateException.class, () -> order.cancel("2022-12-12 12:01:01"));
        order.addProduct("111",10);
        order.addProduct("111",1);
        order.removeProduct("111");
        order.addProduct("222",1);
        assertThrows(IllegalStateException.class, () ->order.manageProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.complete("2022-12-12 12:01:01"));
        order.screenInfo();
        order.checkout();
        assertThrows(IllegalStateException.class, () ->order.addProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.removeProduct("111"));
        assertThrows(IllegalArgumentException.class, () ->order.manageProduct("111",1));
        order.manageProduct("222",1);
        order.shopping();
        order.checkout();
        assertThrows(IllegalStateException.class, () ->order.complete("2022-12-12 12:01:01"));
        assertThrows(IllegalStateException.class, () ->order.cancel("2022-12-12 12:01:01"));
        order.screenInfo();
        order.checkout();
        order.payment();
        order.complete("2022-12-12 12:01:01");
        assertThrows(IllegalArgumentException.class, () ->order.cancel("ILLEGALDATE"));
        assertThrows(IllegalStateException.class, () ->order.addProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.manageProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.removeProduct("111"));
        order.payment();
        order.screenInfo();
        assertThrows(IllegalStateException.class, () -> order.shopping());
        assertThrows(IllegalStateException.class, () -> order.checkout());
        order.cancel("2022-12-13 19:50:01");
        assertThrows(IllegalStateException.class, () ->order.addProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.manageProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order.removeProduct("111"));
        assertThrows(IllegalStateException.class, () -> order.shopping());
        assertThrows(IllegalStateException.class, () -> order.payment());
        assertThrows(IllegalStateException.class, () -> order.checkout());
        assertThrows(IllegalStateException.class, () ->order.complete("2022-12-12 12:01:01"));
        assertThrows(IllegalStateException.class, () ->order.cancel("2022-12-12 12:01:01"));
        order.screenInfo();
    }
    @Test
    void ex2(){
        order3.screenInfo();
        order3.shopping();
        order3.addProduct("111",1);
        order3.checkout();
        order3.payment();
        order3.complete("2023-12-15 12:01:01");
        assertThrows(IllegalStateException.class, () ->order3.addProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order3.manageProduct("111",1));
        assertThrows(IllegalStateException.class, () ->order3.removeProduct("111"));
        assertThrows(IllegalStateException.class, () -> order3.checkout());
        assertThrows(IllegalStateException.class, () -> order3.shopping());
        order3.complete("2023-12-15 12:01:01");
        assertThrows(IllegalStateException.class, () ->order3.cancel("2022-12-12 12:01:01"));
        assertThrows(IllegalStateException.class, () ->order3.payment());
        order3.screenInfo();
    }

}