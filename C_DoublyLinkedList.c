#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
	struct node *prev;
}*start,*last;

void insert_beg(int data);
void print();
void insert_end(int data);
void insert_mid(int pos, int data);
void delete_start();
void delete_end();

int main()
{
	insert_end(0);
	insert_beg(2);
	insert_beg(1);
	insert_end(5);
	insert_mid(2,10);
	print();
	delete_start();
	print();
	delete_end();
	print();
	return 0;
}

void insert_beg(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	if(start==NULL)
	{
		  start = temp;
		temp->next = NULL;
		temp->prev = NULL;
		last = start;
	}
	else
	{
		ptr = temp;
		temp ->prev = NULL;
		temp->next = start;
		start->prev = temp;
		start = temp;
	}
	
}

void insert_end(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	if(start==NULL)
	{
		start = temp;
		temp->prev = NULL;
		temp ->next = NULL;
		last = start;
	}
	else
	{
		ptr = start;
		while(ptr->next!=NULL)
		{
			ptr = ptr ->next;
		}
		ptr->next = temp;
		temp->prev = ptr;
		temp ->next = NULL;
	}
}

void insert_mid(int pos, int data)
{
	struct node *temp, *ptr, *ptr2;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	int count=0;
	ptr = start;
	//ptr2 = start;

	for(;count<pos-2;count++)
	{
		ptr = ptr -> next;
	}
	temp->next = ptr->next;
	ptr->next->prev = temp;
	ptr->next = temp;
	temp-> prev = ptr;

}

void print()
{
	struct node *ptr;
	ptr = start;
	if(start==NULL)
	{
		printf("No elements in the list");
	}
	while(ptr!=NULL)
	{
		printf("%d->",ptr->data);
		ptr = ptr->next;
	}
	printf("End\n");
}

void delete_start()
{
	struct node *ptr;
	ptr = start;
	start = ptr->next;
	ptr->next->prev = NULL;
	ptr->next = NULL;
}

void delete_end()
{
	struct node *ptr;
	ptr = start;
	while(ptr->next->next!=NULL)
	{
		ptr = ptr->next;
	}
	ptr->next->prev = NULL;
	ptr->next = NULL;

}
