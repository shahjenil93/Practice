#include<stdio.h>
#include<stdlib.h>

struct ArrayStack
{
	int top;
	int capacity;
	int *array;
};

struct ArrayStack *CreateStack()
{
	struct ArrayStack *S = malloc(sizeof(struct ArrayStack));
	if(!S)
	{
		return NULL;
	}
	S->capacity = 1;
	S->top = 1;
	S->array = malloc(sizeof(S->capacity*sizeof(int)));
	if(!S->array)
	{
		return NULL;
	}
	return S;
}

int IsStackEmpty(struct ArrayStack *S)
{
	return (S->top==-1);
}

int IsStackFull(struct ArrayStack *S)
{
	return (S->top==S->capacity-1);
}

void push(struct ArrayStack *S, int data)
{
	if(IsStackFull(S))
	{
		printf("Stack is Full");
	}
	else
	{
		S->array[++S->top]=data;
	}
}

int pop(struct ArrayStack *S)
{
	if(IsStackEmpty(S))
	{
		printf("Stack is empty");
		return 0;
	}
	else
	{
		S->top = S->top--;
		return S->array[S->top];
	}
}

int main()
{
	push(&S,3);
	push(&S,2);
	push(&S,1);
	return 0;
}