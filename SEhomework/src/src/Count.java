package src;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
	//行数
   public static int CountLine(String filename) {
	   int LineNum = 0;     
	   FileReader file = null;   //尚未分配内存空间
	   BufferedReader brin = null;       //尚未分配内存空间
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   while((brin.readLine()) != null)  {     //循环读取分行文本，判断是否已经读到文件末尾
			   LineNum++;                    //行数+1
		   }
		   System.out.println("文件的行数为：" + LineNum);
		   brin.close();           //关闭流
		   file.close();
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "无法在该路径找到文件");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "输入的文件名有误");
		   return -1;
	   }
	   return LineNum;
   }
   
   //词数
   public static int CountWord(String filename) {
	   String s;
	   String[] s3 = null;
	   int WordNum = 0;
	   FileReader file = null;
	   BufferedReader brin = null;
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   Pattern p = Pattern.compile("[_a-zA-Z]+");      //指定正则表达式的规则为至少匹配一个下划线、大小写英文字母
		   Matcher m = null;
		   while((s = brin.readLine()) != null) {   //分行文本非空时，将分行文本插入到sb中
			   s = s.replaceAll("[^_a-zA-Z]"," ");     //此处认为数字不属于单词，且文件中的单词可含下划线
			   s3 = s.trim().split("\\s+");   //先把两端的空格去掉，再对中间内容根据空格进行分割
			   for(int i = 0; i<s3.length;i++) {
				   m = p.matcher(s3[i]);      //把s3的每个元素都返回Matcher实例
				   if(m.matches()) {        //验证s3[i]中的每个元素是否与Pattern.compile的正则表达式模式一致
					   WordNum++;           //一致则单词数++
				   }
			   }
		   }
		   System.out.println("文件的单词数为：" + WordNum);
		   brin.close();          //关闭流
		   file.close();          //关闭文件流
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "无法在该路径找到文件");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "输入的文件名有误");
		   return -1;
	   }//由于PatternSyntaxException为运行时刻异常，此处不进行处理
	   return WordNum;
   }
   
   //字符数
   public static int CountCharacter(String filename) {
	   String s;   
	   int CharNum = 0;
	   char[] ch;
	   FileReader file = null;
	   BufferedReader brin = null;
	   try {
		   file = new FileReader(filename);
		   brin = new BufferedReader(file);
		   while((s = brin.readLine()) != null) {    //分行读取文本，结果为string类型
			   ch = s.toCharArray();  //将一行读取出来的内容存入字符数组中
			   for(char temp : ch) {      //遍历ch数组，如果发现有空格则不对CharNum进行++操作
				   if(temp != ' ') {
					   CharNum++;
				   }
			   }
		   }
		   System.out.println("文件的字符数为：" + CharNum);
		   brin.close();        //关闭流
		   file.close();
	   }catch (FileNotFoundException e) {
		   System.out.println(filename + "无法在该路径找到文件");
		   return -1;
	   }catch (IOException e) {
		   System.out.println(filename + "输入的文件名有误");
		   return -1;
	   }
	   return CharNum;
   }
   
   
}
