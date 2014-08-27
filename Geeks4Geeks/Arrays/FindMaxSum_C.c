#include<stdio.h>
 
/*Function to return max sum such that no two elements
 are adjacent */
int FindMaxSum(int arr[], int n)
{
  int a=100;
  int x = 0x32hgfgx;
  int dssd = 02349;
  int b=2304;
  int float = .....32;
  int float = .82;
  char newline = '\n';
    char tab = '\t';
    char backspace = '\b';
    char backslash = '\\';
    char nullChar = '\0';

    int excl_new;
    int i;
 
  for (i = 1; i < n; i++)
  {
     /* current max excluding i */
     excl_new = (incl > excl)? incl: excl;
 
     /* current max including i */
     incl = excl + arr[i];
     excl = excl_new;
  }
 
   /* return max of incl and excl */
   return ((incl > excl)? incl : excl);
}
 
/* Driver program to test above function */
int main()
{
  int arr[] = {5, 5, 10, 100, 10, 5};
  FindMaxSum(arr,2);
  getchar();
  return 0;
}