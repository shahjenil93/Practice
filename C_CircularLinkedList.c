#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
}*head, *tail;

void insert_beg(int data);
void print();
void insert_end(int data);
void delete_beg();

int main()
{
	insert_beg(2);
	insert_beg(1);
	insert_end(5);
	insert_beg(0);
	print();
	delete_beg();
	print();
	return 0;
}

void insert_beg(int data)
{
	struct node *ptr, *temp;
	temp = (struct node*)malloc(sizeof(struct node));
	temp->data = data;
	if(head==NULL)
	{
		head = temp;
		temp->next = head;
	}
	else
	{
		ptr = head;
		temp->next = ptr;
		
		while(ptr->next!=head)
		{
			ptr = ptr->next;
		}
		ptr->next = temp;
		head = temp;
	}
}

void insert_end(int data)
{
	struct node *ptr,*temp;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->data=data;
	ptr = head;
	while(ptr->next!=head)
	{
		ptr= ptr->next;
	}
	temp->next = ptr->next;
	ptr->next = temp;


}

void delete_beg()
{
	struct node *ptr,*start;
	ptr = head;
	start= head;
	while(ptr->next!=head)
	{
		ptr = ptr->next;
	}

	ptr->next = start->next;
	head= ptr->next;
	start->next = NULL;
}


void print()
{
	struct node *ptr;
	ptr = head;
	while(ptr->next!=head)
	{
		printf("%d->",ptr->data);
		ptr = ptr->next;
	}	
	printf("%d\n",ptr->data);			
}

