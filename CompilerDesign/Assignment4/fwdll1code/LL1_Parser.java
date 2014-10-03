
import java.io.*;
import java.util.Stack;
import java.util.Iterator;

public class LL1_Parser{
//input
   public String input="";//"i*i$"
    private int indexOfInput=-1;
    //Stack
    Stack <String> strack=new Stack<String>();
    String nonTers[] = new String[20];
    String left[]= new String[20];
    String right[] = new String[20];
    String right1[][] = new String[20][6];
    String follow[][];
    int fcount[]= new int[20];
    String [][] first;
    //Table of rules
    String [][] table;
    int l_len=0,r_len=0;
    String [] terminals=new String[20];


public LL1_Parser(String in)
{
this.input=in;
}

private  void pushRule(String rule)
{
for(int i=rule.length()-1;i>=0;i--)
{
char ch=rule.charAt(i);
String str=String.valueOf(ch);
push(str);
}
}

    //algorithm
public void algorithm    ()
{

    
    push(this.input.charAt(0)+"");//
    push("G");
    //Read one token from input
    
    String token=read();
    String top=null;
    
    do
    {
        System.out.println();
      Iterator <String> it = strack.iterator();
                while(it.hasNext()){
                    System.out.print(it.next());
                }
        top=this.pop();
        //if top is non-terminal
        if(isNonTerminal(top))
        {
        String rule=this.getRule(top, token);
        this.pushRule(rule);
        }
        else if(isTerminal(top))
        {
        if(!top.equals(token))
{
error("this token is not corrent , By Grammer rule . Token : ("+token+")");
}
else
{
    System.out.println("\t Matching: Terminal :( "+token+" )");
token =read();
//top=pop();

}
        }
        else
        {
        error("Never Happens , Because top : ( "+top+" )");
        }
        if(token.equals("$"))
        {
        break;
        }
        //if top is terminal
    
    }while(true);//out of the loop when $
    
    //accept
    if(token.equals("$"))
        {
         System.out.println("Input is Accepted by LL1");   
        }
    else
    {
     System.out.println("Input is not Accepted by LL1");   
    }
}

    private boolean isTerminal(String s) {
               for(int i=0;i<this.terminals.length;i++)
        {
        if(s.equals(this.terminals[i]))
        {
        return true;
        }

        }
              return false;
    }

    private boolean isNonTerminal(String s) {
        for(int i=0;i<this.nonTers.length;i++)
        {
        if(s.equals(this.nonTers[i]))
        {
        return true;
        }

        }
              return false;
    }

    private String read() {
        indexOfInput++;
        char ch=this.input.charAt(indexOfInput);
String str=String.valueOf(ch);

        return str;
    }

    private void push(String s) {
     this.strack.push(s);   
    }
        private String pop() {
   return this.strack.pop();   
    }

    private void error(String message) {
        System.out.println(message);
        throw new RuntimeException(message);
    }
    public String getRule(String non,String term)
    {
        
    int row=getnonTermIndex(non);
    int column=getTermIndex(term);
    String rule=this.table[row][column];
    if(rule==null)
    {
    error("There is no Rule by this , Non-Terminal("+non+") ,Terminal("+term+") ");
    }
    System.out.print("\t"+non+"->"+rule);
    return rule;
    }

    private int getnonTermIndex(String non) {
       for(int i=0;i<this.nonTers.length;i++)
       {
       if(non.equals(this.nonTers[i]))
       {
       return i;
       }
       }
       error(non +" is not NonTerminal");
       return -1;
    }

    private int getTermIndex(String term) {
              for(int i=0;i<this.terminals.length;i++)
       {
       if(term.equals(this.terminals[i]))
       {
       return i;
       }
       }
       error(term +" is not Terminal");
       return -1;
    }
    
        //main
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        
        LL1_Parser parser=new LL1_Parser("a+(a+a*(a)+a)$");//i*i+(i+i)$  a+(a+a*(a)+a)$
        parser.first();
        parser.algorithm();
  
    }
    public void first()throws IOException
     {
      
      BufferedReader br = new BufferedReader(new FileReader("grammar.txt"));
      
      String line;
      
      while ((line = br.readLine()) != null) {
         left[l_len++]=line.split("->")[0];
         right[r_len++]=line.split("->")[1];
      }
      br.close();
      
      for(int i  = 0; i < r_len ;i++)
        {
          right1[i]=right[i].split("/");
        }

      for(int i  = 0; i < r_len ;i++)
          {
            for(int j = 0; j < right1[i].length ;j++)
               {
                 System.out.print("\t"+right1[i][j]);
               }
            System.out.print("\n ");
          }
        first = new String[r_len][5];

         for(int i  = 0; i < l_len ;i++)
          cal_first(left[i]);

         int t_len=0;
         System.out.print("\nFirst");
         for(int i  = 0; i < first.length ;i++)
          {
           System.out.print("\n");
           for(int j = 0; j < first[i].length ;j++)
               {
                if(first[i][j]!=null)
                System.out.print("  "+first[i][j]);
                if(java.util.Arrays.asList(terminals).indexOf(first[i][j])==-1)
                {
                  if(!first[i][j].equals("e") && first[i][j]!=null)
                  {
                    terminals[t_len]=first[i][j];
                    ++t_len;
                  }
                }
               }

          }
          follow= new String[l_len][20];
         
         follow[0][0]="$";
         fcount[0]=1;

         for(int i  = 0; i < l_len ;i++) {             
             if(i>0)
               {
                fcount[i]=0;
               }
             }
           for(int i  = 0; i < l_len ;i++)
             cal_follow(left[i]);   

          System.out.print("\nFOLLOW");
          for(int i  = 0; i < l_len ;i++)
          {
           System.out.print("\n");
           for(int j = 0; j < fcount[i] ;j++)
               {
                System.out.print("  "+follow[i][j]);
                if(java.util.Arrays.asList(terminals).indexOf(follow[i][j])==-1)
                {
                  if(!follow[i][j].equals("e") && follow[i][j]!=null)
                  {
                    terminals[t_len]=follow[i][j];
                    ++t_len;
                  }
                }
               }
           }
           int nt_len=0;
           for(int i  = 0; i < l_len ;i++)
           {
            if(java.util.Arrays.asList(nonTers).indexOf(left[i])==-1)
              nonTers[nt_len++]=left[i];
           }
          System.out.print("\n");
          table= new String[nt_len][t_len];
          for(int i  = 0; i < r_len ;i++)
          {
            for(int j = 0; j < right1[i].length ;j++)
               {
                if((right1[i][j].charAt(0)< 'A' || right1[i][j].charAt(0) >'Z') && !right1[i][j].equals("e"))
                  {
                   table[i][java.util.Arrays.asList(terminals).indexOf(""+right1[i][j].charAt(0))] = right1[i][j];
                  }
                else if(right1[i][j].equals("e"))
                  {
                    for(int k=0; k<follow[i].length; ++k)
                    {
                      if(follow[i][k]!=null)
                      table[i][java.util.Arrays.asList(terminals).indexOf(""+follow[i][k])]="";
                    }
                  }
                else
                {
                  int h,q=0,r=0,p,flag=0;
                  String first_temp[]= new String[20];                  
                  h=java.util.Arrays.asList(left).indexOf(""+right1[i][j].charAt(0));
                  p=h;
                  do{
                    flag=0;
                      ++r;
                      for(int k=0; k<first[p].length; ++k)
                      { 
                        if(first[p][k]!=null)
                        {
                          if(!first[p][k].equals("e"))           
                            first_temp[q++]=first[p][k];
                          else flag=1;
                        }
                      }
                      
                      if(flag==1 && right1[i][j].length()==r)
                        {first_temp[q++]="e";flag=0;}
                       else if(right1[i][j].length()==r) flag=0;
                       else if(right1[i][j].charAt(r)>='a' && right1[i][j].charAt(r) <='z' && flag==1)
                        {first_temp[q++]=""+right1[i][j].charAt(r);flag=0;}
                       else {}

                      if(flag==1)p=java.util.Arrays.asList(left).indexOf(""+right1[i][j].charAt(r)); 
                    }while(flag==1);
                  
                  for(int k=0; k<q; ++k)
                  {
                    if(!first_temp[k].equals("e"))
                    table[i][java.util.Arrays.asList(terminals).indexOf(""+first_temp[k])]=right1[i][j];
                  }
                   if(java.util.Arrays.asList(first_temp).indexOf("e")!=-1)
                   {
                    for(int k=0; k<follow[i].length; ++k)
                    {
                      if(follow[i][k]!=null)
                      table[i][java.util.Arrays.asList(terminals).indexOf(""+follow[i][k])]=right1[i][j];
                    }
                   }
                }  

               }
          }
          System.out.print("\n \t");
          for(int i  = 0; i < t_len ;i++)
          {
            System.out.print("\t"+terminals[i]);
          }
          System.out.print("\n \t");
          for(int i  = 0; i < t_len ;i++)
          {
            System.out.print("\t______");
          }
          for(int i  = 0; i < nt_len ;i++)
          {
            System.out.print("\n");
            System.out.print("\t"+nonTers[i]+"|");
           for(int j  = 0; j < t_len ;j++ )
           {
            System.out.print("\t"+table[i][j]);
           }
          }
          System.out.print("\n");
      }

    public String[] cal_first(String s)
    {

     int ll=0,p=0,index;
     index=java.util.Arrays.asList(left).indexOf(""+s.charAt(0));
     if(first[index][0]!=null)return first[index];
     String temp[]= new String[20];
     if(s.charAt(0)<'A' || s.charAt(0)>'Z') {String []temp1={s}; return temp1;}
     else
     {
      for(int i  = 0; i < r_len ;i++)
        {
         if(left[i].charAt(0)==s.charAt(0))
         {
           for( int j  = 0; j < right1[i].length ;j++)
              {
                while(p<right1[i][j].length())
                {
                  if(right1[i][j].charAt(p)< 'A' || right1[i][j].charAt(p) >'Z')
                      {
                       first[i][ll++]=""+right1[i][j].charAt(p);
                       break;
                      }
                  else
                     {
                        temp=cal_first(""+right1[i][j].charAt(p));
                        for(int k=0;k<temp.length;++k)
                        {
                          if(temp[k]!=null && !temp[k].equals("e"))first[i][ll++]=temp[k];
                        }
                        if(java.util.Arrays.asList(temp).indexOf("e")==-1)
                          break;
                        else
                        {
                          if(p==right1[i][j].length()-1)first[i][ll++]="e";
                        }
                     }
                  ++p; 
                }   
              }
            return first[i];  
          }  
        }
        String []temp1={};
        return temp1;
      }  

    }

    public String[] cal_follow(String s)
    {
      int index;
      index=java.util.Arrays.asList(left).indexOf(""+s.charAt(0));
      if(follow[index][0]!=null && index!=0)return follow[index];

             for( int j  = 0; j < r_len ;j++)
                {
                 for( int h  = 0; h < right1[j].length ;h++)
                    {
                     if(right1[j][h].contains(left[index]))
                       { 
                         int B = right1[j][h].indexOf(left[index]);
                         String a =right1[j][h].substring(0, B);
                         String b =right1[j][h].substring(B+1,right1[j][h].length());

                         if(b.isEmpty())
                           {
                            String temp[];
                            if(j!=index)
                              {
                                temp=cal_follow(left[j]);
                                for(int k = 0; k < temp.length ;k++) 
                                  { 
                                    if(temp[k]!=null && java.util.Arrays.asList(follow[index]).indexOf(temp[k])==-1)
                                    follow[index][fcount[index]++]= temp[k]; 
                                  } 
                                  System.out.print("\n");
                              }  
                            }  
                        else 
                          { 
                            if((int)b.charAt(0)>='A'&& (int)b.charAt(0)<='Z')
                             {
                              for(int k = 0; k < l_len ;k++)
                                 {
                                  if(left[k].charAt(0)==b.charAt(0))
                                    {
                                     for(int m = 0; m < first[k].length;m++)
                                        {
                                         if(first[k][m]!=null)
                                         { 
                                         if(first[k][m].equalsIgnoreCase("e") && b.length()!=1)
                                           {

                                           }
                                         else if(first[k][m].equalsIgnoreCase("e") && b.length()==1 && index!=j)
                                         {
                                          String temp[];
                                          temp=cal_follow(left[j]);                                          
                                          for(int kk = 0; kk < temp.length ;kk++) 
                                            { 
                                              if(temp[kk]!=null && java.util.Arrays.asList(follow[index]).indexOf(temp[kk])==-1)
                                              follow[index][fcount[index]++]= temp[kk];
                                            } 
                                         }  
                                         else
                                           {
                                            if(java.util.Arrays.asList(follow[index]).indexOf(first[k][m])==-1)
                                            follow[index][fcount[index]++]=first[k][m];
                                           }
                                          } 
                                        }
                                      break;
                                     }

                                  }

                            }
                         else
                            {
                              follow[index][fcount[index]++]=b;
                            }
                        }
                     }
                   }
                }
                return follow[index];
            
    }

}
/*
 
 */