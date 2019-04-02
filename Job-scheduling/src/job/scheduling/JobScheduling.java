/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job.scheduling;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author Mohammad_Abdullah
 */
public class JobScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Jobs");
        int num = sc.nextInt();
        String[] title = new String[num];
        int[] time = new int[num];
        int[] pri = new int[num];
        System.out.println("Enter jobs in this format--> title time priority");
        for (int i = 0; i < num; i++) {
            title[i] = sc.next();
            time[i] = sc.nextInt();
            pri[i] = sc.nextInt();
        }

        //copying Arrays!
        int[] ctime = time.clone();
        String[] ctitle = title.clone();
        int[] cpri = pri.clone();

        int[] cctime = time.clone();
        String[] cctitle = title.clone();

        //Bubble sort
        int j;
        boolean flag = true;
        int temp;
        String temp_s;

        while (flag) {
            flag = false;
            for (j = 0; j < time.length - 1; j++) {
                if (time[j] > time[j + 1]) {
                    temp = time[j];
                    time[j] = time[j + 1];
                    time[j + 1] = temp;
                    flag = true;

                    temp = pri[j];
                    pri[j] = pri[j + 1];
                    pri[j + 1] = temp;

                    temp_s = title[j];
                    title[j] = title[j + 1];
                    title[j + 1] = temp_s;

                }
            }
        }

        int[] ccctime = time.clone();
        String[] ccctitle = title.clone();

        System.out.println("Round Robin");
        //Round Robin
        int t = 6;
        String[] done = new String[num];
        int[] done_t = new int[num];
        int lala = 0;
        int l = IntStream.of(time).sum();     //Summing the elements of array!
        for (int h = 0; h < l; h++) {
            for (int i = 0; i < time.length; i++) {
                if (time[i] > 0) {
                    time[i] = time[i] - 1;
                    if (time[i] == 0) {
                        t = t - 1;
                        done[lala] = title[i];
                        done_t[lala] = t * 2;
                        lala++;
                    }
                }

            }
        }
        t = 0;
        for (int i = 0; i < done.length; i++) {
            t = t + done_t[i];
            System.out.println(done[i] + ":" + t);
        }

        //Bubble sort --> Priority
        flag = true;

        while (flag) {
            flag = false;
            for (j = 0; j < ctime.length - 1; j++) {
                if (cpri[j] < cpri[j + 1]) {
                    temp = ctime[j];
                    ctime[j] = ctime[j + 1];
                    ctime[j + 1] = temp;
                    flag = true;

                    temp = cpri[j];
                    cpri[j] = cpri[j + 1];
                    cpri[j + 1] = temp;

                    temp_s = ctitle[j];
                    ctitle[j] = ctitle[j + 1];
                    ctitle[j + 1] = temp_s;

                }
            }
        }
        System.out.println("Priority Scheduling");
        //Priority Scheduling
        t = 0;
        for (int i = 0; i < num; i++) {
            t = t + ctime[i];
            System.out.println(ctitle[i] + ":" + t);
        }
        System.out.println("First Come First Serve");
        //FCFS
        t = 0;
        for (int i = 0; i < num; i++) {
            t = t + cctime[i];
            System.out.println(cctitle[i] + ":" + t);
        }
        System.out.println("Shortest Job First");
        //SJF
        t = 0;
        for (int i = 0; i < num; i++) {
            t = t + ccctime[i];
            System.out.println(ccctitle[i] + ":" + t);
        }

    }

}
