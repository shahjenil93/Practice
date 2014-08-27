#include<stdio.h>
#include<stdlib.h>

void create(int data);
void insert_beg(int data);
void insert_end(int data);
void print();
void delete(int pos);


struct node
	{
		int data;
		struct node *next;
	}*start;

int main()
{
	
	//create(2);
	insert_beg(1);
	insert_end(3);
	print();
	delete(2);
	print();

}

void create(int data)
{
	struct node *temp;
	temp = (struct node *)malloc(sizeof(struct node));

	if(start==NULL)
	{
		temp->data = data;
		temp->next = NULL;
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

void insert_beg(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	ptr = start;
	temp->data = data;
	temp->next = ptr;
	start = temp;
}

void insert_end(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	ptr = start;
	temp -> data = data;
	while(ptr->next!=NULL)
	{
		ptr = ptr->next;
	}
	ptr->next = temp;
	temp->next = NULL;
}

void delete(int pos)
{
	struct node *temp, *ptr;
	ptr = start;
	for(int i=0;i<pos-2;i++)
	{
		ptr = ptr->next;
	}
	ptr -> next = ptr->next->next;

}