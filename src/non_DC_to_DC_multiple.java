/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sangharatana Godboley
 */

public class non_DC_to_DC_multiple {

public static void main(String[] args) throws FileNotFoundException, IOException{
         BufferedReader fpReadPredicate1 = new BufferedReader(new FileReader("ETTRAW_non_DC.txt"));
         PrintWriter out_truthTable1=new PrintWriter("With_DC_truthTable.txt");
         String r=fpReadPredicate1.readLine();
         int total_predicates=0;
          int valueset=0;
          String r1="";
          while(r!=null)
            { //r=r.trim();

            if(r.contains("Test Case File Number is")){
                valueset=1;
                r1=r;
           }
            if (r.contains("Predicate")){
                total_predicates++;
                PrintWriter out_truthTable=new PrintWriter("../src/With_DC_truthTable_fileGeneration"+total_predicates+".java");
         out_truthTable.println("import java.io.BufferedWriter;\n" +
"import java.io.FileNotFoundException;\n" +
"import java.io.FileWriter;\n" +
"import java.io.IOException;\n" +
"import java.io.PrintWriter;\n" +
"" +
"\n" +
"/**\n" +
" *\n" +
" * @author user\n" +
" */\n" +
"public class With_DC_truthTable_fileGeneration"+total_predicates+" {\n" +
"    public static void main(String args[]) throws FileNotFoundException, IOException{\n" +
"    PrintWriter out_truthTable=new PrintWriter(new BufferedWriter(new FileWriter(\"With_DC_truthTable.txt\",true)));\n" +
"    boolean array[]=new boolean[100000];\n" +
"    int t[]=new int[100000];\n" +
"    boolean exper_val=false;");
         if(valueset==1){ out_truthTable.println(" out_truthTable.println(\""+r1+"\");");valueset=0;}
                out_truthTable.println(" out_truthTable.println(\""+r+"\");");
             int colon_place=r.indexOf(':');
             String rep=r.substring(0, colon_place+1);
             r=r.replace(rep, "");
             r=r.replace("||", "`");
             r=r.replace("&&", "#");
             r=r.replace(" ", "");r=r.replace("+", "");
             r=r.replace(" ", "");r=r.replace("-", "");
             r=r.replace(" ", "");r=r.replace("*", "");
             r=r.replace(" ", "");r=r.replace("/", "");
             r=r.replace(" ", "");r=r.replace("%", "");
             r=r.replace("[", "");
             r=r.replace("]", "");
             String req_r=r;
             r=r.replace("(", "");
             r=r.replace(")","");
              r=r.replace("!=","Y;Y");
              r=r.replace("!","");
              r=r.replace("Y;Y","!=");
               int i_char=65;
             String k[]=r.split("`");
             if(k.length>=2){
              for(String rp:k){
                  req_r=req_r.replaceFirst(rp, (char)i_char+++"");
              if(rp.contains("#")){
              String k1[]=rp.split("#");
              for(String rp1:k1){
              req_r=req_r.replaceFirst(rp1, (char)i_char+++"");}
              }
              }
             }else{String k1[]=r.split("#");
              for(String rp1:k1){
              req_r=req_r.replaceFirst(rp1, (char)i_char+++"");}
              }
             i_char=65;
            req_r=req_r.replace("`", "||");
             req_r=req_r.replace("#", "&&");
              System.out.println(req_r);
              ///----------------Changing in required ABC format----------
              String str_req_r=req_r;
              req_r=req_r.replace("|", "k");
              req_r=req_r.replace("(", "").replace(")", "").replaceAll("&", "").replaceAll("!", "").replaceAll("k", "");
              int no_of_var=req_r.length();
              for (int pv=0;pv<no_of_var;pv++){
              out_truthTable.println("t["+pv+"]="+pv+";");
                 }
              r=fpReadPredicate1.readLine();
              String truth_false_value[]=r.split(",");
              for (int apv=0;apv<no_of_var;apv++){
                  if(truth_false_value[apv].contains("0"))
                       out_truthTable.println("array["+apv+"]="+false+";");
                  else
                       out_truthTable.println("array["+apv+"]="+true+";");
              }


              char[] arr2 = str_req_r.toCharArray();
              String expr="";
    for (int i=0,j=0; i<str_req_r.length(); i++){
    if(arr2[i]>='A'&& arr2[i]<='Z'){
    expr=expr+"array[t["+j+"]++]";
    j++;
    }
    else{
        expr=expr+arr2[i];
    }
    }
        out_truthTable.println(" exper_val=("+expr+");");

              out_truthTable.println("for(int i=0;i<"+no_of_var+";i++){\n" +
"    if(t[i]!=i){\n" +
"        if(array[i]){\n" +
"        out_truthTable.print(\"1,\");\n" +
"        }\n" +
"        else{\n" +
"        out_truthTable.print(\"0,\");\n" +
"        }\n" +
"    }\n" +
"    else{\n" +
"        out_truthTable.print(\"X,\");\n" +
"            }\n" +
"    }\n" +
"    {\n" +
"        if(exper_val){\n" +
"        out_truthTable.println(\"1\");\n" +
"        }\n" +
"        else{\n" +
"        out_truthTable.println(\"0\");\n" +
"        }" +
"            }");

out_truthTable.println("out_truthTable.flush();\n" +
"    }\n" +
"    \n" +
"}\n" +
"");
    out_truthTable.flush();

      }
          r=fpReadPredicate1.readLine();
     }
    }
}
