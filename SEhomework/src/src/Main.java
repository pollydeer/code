package src;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{
    	int i;
    	String temp = null;
        System.out.println("请输入命令：");
        Scanner input = new Scanner(System.in);     //从cmd输入控制参数及file_name
        if(input.hasNext()) {
                temp = input.nextLine();             //结束扫描的输入
        	}
        	String[] strwords = temp.split(" ");         //用空格分隔输入的参数以及文件名
        	String filename = strwords[strwords.length-1];     //路径为输入的最后一个参数
        	
        	
            for(i = 0; i<strwords.length-1; i++)   //从开头到文件名字前面都是属于parameter
            	{
            		if(strwords[i].equals("-c")) 
            			Count.CountCharacter(filename);
            		if(strwords[i].equals("-w"))
            			Count.CountWord(filename);
            		if(strwords[i].equals("-l"))
            			Count.CountLine(filename);
            	}
        	input.close();   //关闭流   
    }
}
