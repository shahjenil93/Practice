#include<stdio.h>
#include<stdlib.h>


void insert(int data);
void print();

struct node
{
	int data;
	struct node *next;	
}*start;


int main()
{
	insert(1);
	insert(2);
	insert(3);
	print();
	return 0;
}

void insert(int data)
{
	struct node *temp, *temp2;
	temp = (struct node*)malloc(sizeof(struct node));
	temp -> data  = data;
	if(start==NULL)
	{
		start = temp;
		temp->next = NULL;
	}
	else
	{
		temp2 = start;
		while(temp2->next!=NULL)
		{
			temp2 = temp2->next;
		}

		temp2->next= temp;
		temp->next = NULL;
	}
}

insert

void print()
{
	struct node *temp;
	temp = start;
	while(temp!=NULL)
	{
		printf("%d ->",temp->data);
		temp = temp->next;
	}	

}

void insert_between(int data, int pos)
{
	struct node *temp, *temp2;
	temp = (struct node*)malloc(sizeof(struct node));
	temp -> data = data;
	temp2 = start;
	int i=1;
	while(i!=pos)
	{
		temp2 = temp2->next;
		i++;
	}
	temp->next = temp2->next;
	temp2->next = temp;
}

void delete(int pos)
{
	int i=1;
	struct node *temp;
}