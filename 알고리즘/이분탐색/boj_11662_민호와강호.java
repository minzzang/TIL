 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-24
  * URL   : https://www.acmicpc.net/problem/11662
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double x3 = Double.parseDouble(st.nextToken());
        double y3 = Double.parseDouble(st.nextToken());
        double x4 = Double.parseDouble(st.nextToken());
        double y4 = Double.parseDouble(st.nextToken());

        int interval = 1000000;
        double min = distance(x1, y1, x3, y3);

        double dX1 = (x2-x1) / interval;
        double dY1 = (y2-y1) / interval;

        double dX2 = (x4-x3) / interval;
        double dY2 = (y4-y3) / interval;

        for (int i=1; i<=interval; i++) {

            double dist = distance(x1+(dX1*i), y1+(dY1*i), x3+(dX2*i), y3+(dY2*i));

            if (dist < min) {
                min = dist;
            }
        }
        System.out.println(min);


    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
}