public class Program{
	public static void main(String args[])
	{			
		int[][] array= {{7,8,0,4,0,0,1,2,0},
						{6,0,0,0,7,5,0,0,9},
						{0,0,0,6,0,1,0,7,8},
						{0,0,7,0,4,0,2,6,0},
						{0,0,1,0,5,0,9,3,0},
						{9,0,4,0,6,0,0,0,5},
						{0,7,0,3,0,0,0,1,2},
						{1,2,0,0,0,7,4,0,0},
						{0,4,9,2,0,6,0,0,7}};
			Sudo p=new Sudo(array);
			p.print();
			System.out.println("-----------------\n----------------");
			if(p.soln())
			{
				p.print();
			}
			else
				System.out.println("unsuccessful");
			System.out.println("----------------------------");
	}
}
 class Sudo{
	int[][] array;
	public Sudo()
	{
		array=new int[9][9];
	}
	public Sudo(int[][] arr)
	{
		this.array=arr;
	}
	public void print()
	{
		for(int i=0;i<9;i++)
		{
			if(i%3==0&&i!=0)
			{
				System.out.println("-----------------------");
			}
			for(int j=0;j<9;j++)
			{
				if(j%3==0&&j!=0)
				{	
					System.out.print("|");
					System.out.print(array[i][j]+" ");
				}
				else
					System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public boolean check(int input,int i,int j)
	{
		for(int l=0;l<9;l++)
		{
			if(input==array[l][j])
			{
				return false;
			}
		}
		for(int m=0;m<9;m++)
		{
			if(input==array[i][m])
			{
				return false;
			}
		}
		int x=i/3;
		int y=j/3;
		for(int u=x*3;u<x*3+3;u++)
		{
			for(int v=y*3;v<y*3+3;v++)
			{
				if(array[u][v]==input)
				{
					
					return false;
				}
			}
		}
		return true;
	}
	public boolean soln()
	{
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				if(array[row][col]==0)
				{
					for(int i=1;i<10;i++)
					{
						if(check(i,row,col))
						{
							array[row][col]=i;
							if(soln())
							{
								return true;
							}
							else
							{
								array[row][col]=0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
