#include<stdio.h>
#include<stdlib.h>

//void push(struct node** head_ref, int new_data);
void insert(int data);
void print();
//void printMiddle();
void reverseList();
//void printNthFromEnd(struct node* temp, int k);

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
 	insert(5);
 	print();
 	reverseList();
 	print();
 }

 /* Given a reference (pointer to pointer) to the head
    of a list and an int, push a new node on the front
    of the list. */


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

void reverseList(struct node **start)
{
	struct node *first, *rest;
	first = start;
	rest = first->next;
	if(rest==NULL)
	{
		return;
	}
	reverseList(&rest);
	first->next->next = first;
	first->next = NULL;
	start = rest;
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