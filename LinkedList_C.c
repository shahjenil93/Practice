#include<stdio.h>
#include<stdlib.h>

struct node
{
	int info;
	struct node *link;
} *start;
void create(int);
void display();
void insert_end(int);
void insert_begining(int);
void delete_end();

int main()
{
	create(5);
	insert_end(8);
	insert_begining(1);
	display();
	insert_end(9);
	display();
	delete_end();
	display();
}

void create(int data)
{
	struct node *temp;
	temp = (struct node *)malloc(sizeof(struct node));
	if(start==NULL)
	{
		temp->info=data;
		//printf("%d",temp->info);
		temp->link=NULL;
		 start = temp;
	}
	printf("List Created");
}

void display()
{
	struct node *ptr;
	ptr = start;
	if(start == NULL)
	{
		printf("Empty Linked List");
		return;
	}
	printf("Linked List \n");
	while(ptr!=NULL)
	{
		printf("%d->",ptr->info);
		ptr=ptr->link;
	}
	printf("End of the list \n");
}

void insert_end(int data)
{
	struct node *ptr;
	ptr = start;
	while(ptr->link!=NULL)
	{
		ptr = ptr->link;
	}
	struct node *temp;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->link = NULL;
	temp->info = data;
	ptr->link = temp;
}

void insert_begining(int data)
{
	struct node *ptr, *temp;
	ptr = start;
	temp = (struct node *)malloc(sizeof(struct node));
	temp->info = data;
	temp->link = ptr;
	start = temp;
}

void delete_end()
{
	struct node *ptr;
	ptr = start;
	while(ptr->link->link!=NULL)
	{
		ptr = ptr->link;
	}
	ptr->link=NULL;
}
