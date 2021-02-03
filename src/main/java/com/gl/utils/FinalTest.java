package com.gl.utils;

import lombok.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 郭亮
 * @date 2021/1/8 17:41
 **/
public class FinalTest {

    public static void main(String[] args) throws SQLException {
        ArrayList<Timi> objects = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            Timi timi = new Timi();
            timi.setS(i + "");
            objects.add(timi);
        }
        for (int i = 0;i < 9; i++) {
            Timi curren = objects.get(i);
            Timi next = objects.get(i+1);
            curren.setTimi(next);
        }
        Timi head = objects.get(0);
        while (head != null) {
            System.out.println(head.getS());
            head = head.getTimi();
        }
    }


    private static Map genMap(){
        return new HashMap();
    }
}

@Data
class Timi {
    private String s;

    private Timi timi;
}
