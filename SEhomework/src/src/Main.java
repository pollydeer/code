package src;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{
    	int i;
    	String temp = null;
        System.out.println("���������");
        Scanner input = new Scanner(System.in);     //��cmd������Ʋ�����file_name
        if(input.hasNext()) {
                temp = input.nextLine();             //����ɨ�������
        	}
        	String[] strwords = temp.split(" ");         //�ÿո�ָ�����Ĳ����Լ��ļ���
        	String filename = strwords[strwords.length-1];     //·��Ϊ��������һ������
        	
        	
            for(i = 0; i<strwords.length-1; i++)   //�ӿ�ͷ���ļ�����ǰ�涼������parameter
            	{
            		if(strwords[i].equals("-c")) 
            			Count.CountCharacter(filename);
            		if(strwords[i].equals("-w"))
            			Count.CountWord(filename);
            		if(strwords[i].equals("-l"))
            			Count.CountLine(filename);
            	}
        	input.close();   //�ر���   
    }
}
