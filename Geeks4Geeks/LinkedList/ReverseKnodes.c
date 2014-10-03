#include<stdio.h>
#include<stdlib.h>


/* Link list node */
struct node
{
    int data;
    struct node* next;
}*start;


//void push(struct node** head_ref, int new_data);
void insert(int data);
void print();
//void reverseEveryKNodes(struct node *head, int k);
void reverseLinkedList_Rec(struct node **head);
void reverseLinkedList_Itr(struct node **head);
//void printMiddle();
struct node *reverseEveryKNodes(struct node *head, int k);

//void printNthFromEnd(struct node* temp, int k);



 int main()
 {
 	insert(1);
 	insert(2);
 	insert(3);
 	insert(4);
 	insert(5);
 	print();
 //	reverseEveryKNodes(&start,3);
 	reverseLinkedList_Rec(&start);
 	print();
 	reverseLinkedList_Itr(&start);
 	print();
	start =  reverseEveryKNodes(start,3);
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

struct node *reverseEveryKNodes(struct node *head, int k)
{
	struct node *p1, *p2, *p3;
	p1 = NULL;
	p2 = head;
	p3 = NULL;
	int count = 0;

	while(count<k && p2!=NULL)
	{
		p3 = p2->next;
		p2->next = p1;
		p1 = p2;
		p2 = p3;
		count++;
	}

	if(p3!=NULL)
		head->next = reverseEveryKNodes(p3,k);
	
	//head = p1;
	return p1;
}

void reverseLinkedList_Rec(struct node **head)
{
	struct node *temp, *first, *rest;
	if (*head==NULL)
	{
		return;
	}

	first = *head;
	rest = first->next;
	if(rest==NULL)
	{
		return;
	}
	reverseLinkedList_Rec(&rest);
	first->next->next = first;
	first->next = NULL;
	*head = rest;

}

void reverseLinkedList_Itr(struct node **head)
{
	struct node *p1, *p2, *p3;
	p1 = NULL;
	p2 = *head;
	//p3 = *head->next;
	while(p2!=NULL)
	{
		p3 = p2->next;
		p2->next = p1;
		p1 = p2;
		p2 = p3;	
	}
	*head = p1;
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