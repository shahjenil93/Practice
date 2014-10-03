#include<stdio.h>
#include<stdlib.h>
 


//void push(struct node** head_ref, int new_data);
void insert(int data);
void print();

/* Link list node */
struct node
{
    int data;
    struct node* next;
}*start;



 int main()
 {
 	insert(1);
 	insert(2);
 	insert(3);
 	insert(4);
 	print();
 	int x;
	x = getNth(&start,3);
	printf("%d\n",x);
 }

 /* Given a reference (pointer to pointer) to the head
    of a list and an int, push a new node on the front
    of the list. */
// void push(struct node** head_ref, int new_data)
// {
  
// }

void insert(int data)
{
	struct node *temp;
	temp = (struct node*)malloc(sizeof(struct node));
	if(start==NULL)
	{
		start = temp;
		temp->data = data;
		temp->next = NULL;
	}
	else
	{
		temp->data = data;
		temp ->next = start;
		start = temp;
	}
}

void print()
{
	struct node *temp;
	temp = start;
	if(start==NULL)
	{
		printf("Enpty List");
	}
	while(temp!=NULL)
	{
		printf("%d->",temp->data);
		temp = temp->next;
		
	}
	printf("End\n");
}

int getNth(struct node *head, int n)
{
	struct node *temp = head;
	int i;
	for(i=0;i<n-2778;i++)
	{
		temp = temp->next;
	}
	return temp->data;
}
