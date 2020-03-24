package src;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
	//����
   public static int CountLine(String filename) {
	   int LineNum = 0;     
	   FileReader file = null;   //��δ�����ڴ�ռ�
	   BufferedReader brin = null;       //��δ�����ڴ�ռ�
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   while((brin.readLine()) != null)  {     //ѭ����ȡ�����ı����ж��Ƿ��Ѿ������ļ�ĩβ
			   LineNum++;                    //����+1
		   }
		   System.out.println("�ļ�������Ϊ��" + LineNum);
		   brin.close();           //�ر���
		   file.close();
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "�޷��ڸ�·���ҵ��ļ�");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "������ļ�������");
		   return -1;
	   }
	   return LineNum;
   }
   
   //����
   public static int CountWord(String filename) {
	   String s;
	   String[] s3 = null;
	   int WordNum = 0;
	   FileReader file = null;
	   BufferedReader brin = null;
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   Pattern p = Pattern.compile("[_a-zA-Z]+");      //ָ��������ʽ�Ĺ���Ϊ����ƥ��һ���»��ߡ���СдӢ����ĸ
		   Matcher m = null;
		   while((s = brin.readLine()) != null) {   //�����ı��ǿ�ʱ���������ı����뵽sb��
			   s = s.replaceAll("[^_a-zA-Z]"," ");     //�˴���Ϊ���ֲ����ڵ��ʣ����ļ��еĵ��ʿɺ��»���
			   s3 = s.trim().split("\\s+");   //�Ȱ����˵Ŀո�ȥ�����ٶ��м����ݸ��ݿո���зָ�
			   for(int i = 0; i<s3.length;i++) {
				   m = p.matcher(s3[i]);      //��s3��ÿ��Ԫ�ض�����Matcherʵ��
				   if(m.matches()) {        //��֤s3[i]�е�ÿ��Ԫ���Ƿ���Pattern.compile��������ʽģʽһ��
					   WordNum++;           //һ���򵥴���++
				   }
			   }
		   }
		   System.out.println("�ļ��ĵ�����Ϊ��" + WordNum);
		   brin.close();          //�ر���
		   file.close();          //�ر��ļ���
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "�޷��ڸ�·���ҵ��ļ�");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "������ļ�������");
		   return -1;
	   }//����PatternSyntaxExceptionΪ����ʱ���쳣���˴������д���
	   return WordNum;
   }
   
   //�ַ���
   public static int CountCharacter(String filename) {
	   String s;   
	   int CharNum = 0;
	   char[] ch;
	   FileReader file = null;
	   BufferedReader brin = null;
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   while((s = brin.readLine()) != null) {    //���ж�ȡ�ı������Ϊstring����
			   ch = s.toCharArray();  //��һ�ж�ȡ���������ݴ����ַ�������
			   for(char temp : ch) {      //����ch���飬��������пո��򲻶�CharNum����++����
				   if(temp != ' ') {
					   CharNum++;
				   }
			   }
		   }
		   System.out.println("�ļ����ַ���Ϊ��" + CharNum);
		   brin.close();        //�ر���
		   file.close();
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "�޷��ڸ�·���ҵ��ļ�");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "������ļ�������");
		   return -1;
	   }
	   return CharNum;
   }
   
   
}
