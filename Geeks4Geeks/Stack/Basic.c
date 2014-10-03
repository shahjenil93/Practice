#include<stdio.h>
#include<stdlib.h>

struct ArrayStack
{
	int top;
	int capacity;
	int *array;
};

struct ArrayStack *createStack()
{
	struct ArrayStack *S = malloc(sizeof(struct ArrayStack));
	if(!S)
		return NULL;
		S->capacity = 1;
		S->top = -1;
		S->array  = malloc(sizeof(S->capacity * sizeof(int)));
		if(!S->array)
			return NULL;
		return S;
}

int IsEmptyStack(struct ArrayStack *S)
{
	return (S->top==-1);
}

int IsStackFull(struct ArrayStack *S)
{
	return (S->top == S->capacity-1);
}

void push(struct ArrayStack *S, int data)
{
	if(IsStackFull)
		printf("Stack Overflow");
	else
	{
		top++;
		S->array[top] = data;
	}
}

int pop(Struct ArrayStack *S)
{
	if(IsEmptyStack)
	{
			printf("Stack underflow");
			return 0;
	}
		
	else
	{
		return S->array[S->top--];
	}
}