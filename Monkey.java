import java.util.Random;


public class Monkey 
{
	private char[][] monkey = new char[3][3];
	private boolean isBad;
	private char head;

	public Monkey()
	{
		isBad = false;
		head = 'o';
		populateArray();
	}

	public Monkey(char headP, boolean isBadP)
	{
		head = headP;
		isBad = isBadP;
		populateArray();
	}


	public void setHead(char c)
	{
		head = c;
	}

	public void raiseLeftHand()
	{
		raiseHand(true);
	}
	public void raiseRightHand()
	{
		raiseHand(false);
	}

	private void raiseHand(boolean isItLeft)
	{
		if (isItLeft)
		{
			monkey[0][2] = '/';	
			monkey[1][2] = ' ';
		}
		else
		{
			monkey[0][0] = '\\';	
			monkey[1][0] = ' ';
		}
	}

	public void raiseLeftLeg()
	{
		raiseLeg(true);
	}
	public void raiseRightLeg()
	{
		raiseLeg(false);
	}

	private void raiseLeg(boolean isItLeft)
	{
		if (isItLeft)
		{
			raiseHand(true);
			monkey[1][2] = '/';	
			monkey[2][2] = ' ';

		}
		else
		{
			raiseHand(false);
			monkey[1][0] = '\\';	
			monkey[2][0] = ' ';

		}
	}
	public void lowerLeftHand()
	{
		lowerHand(true);
	}
	public void lowerRightHand()
	{
		lowerHand(false);
	}

	private void lowerHand(boolean isItLeft)
	{
		if (isItLeft)
		{
			lowerLeg(isItLeft);
			monkey[0][2] = ' ';	
			monkey[1][2] = '\\';
		}
		else
		{
			lowerLeg(isItLeft);
			monkey[0][0] = ' ';	
			monkey[1][0] = '/';
		}
	}

	public void lowerLeftLeg()
	{
		lowerLeg(true);
	}
	public void lowerRightLeg()
	{
		lowerLeg(false);
	}

	private void lowerLeg(boolean isItLeft)
	{
		if (isItLeft)
		{

			monkey[1][2] = ' ';	
			monkey[2][2] = '\\';	
		}
		else
		{

			monkey[1][0] = ' ';	
			monkey[2][0] = '/';			
		}
	}
	//-------------
	private void populateArray()
	{
		monkey[0][1] = head;
		if (isBad)
		{
			monkey[0][0] = '\\';	
			monkey[0][2] = '/';	
			monkey[1][0] = ' ';	
			monkey[1][2] = ' ';	
		}
		else
		{
			monkey[0][0] = ' ';	
			monkey[0][2] = ' ';	
			monkey[1][0] = '/';	
			monkey[1][2] = '\\';	
		}
		monkey [1][1] = '|';
		monkey [2][0] = '/';
		monkey [2][1] = ' ';
		monkey [2][2] = '\\';
	}

	public String toString()
	{
		String toReturn ="";
		for (int i = 0; i <monkey.length; i++)
		{
			for (int j=0; j<monkey[i].length; j++)
			{
				toReturn += monkey[i][j];
			}
			toReturn +='\n';
		}
		return toReturn;

	}

	public String getTopMonkeyPart()
	{
		return getPart(0);
	}

	public String getMiddleMonkeyPart()
	{
		return getPart(1);
	}
	public String getBottomMonkeyPart()
	{
		return getPart(2);
	}
	
	private String getPart(int i)
	{
		return ""+monkey[i][0]+monkey[i][1]+monkey[i][2];
	}
	
	
	public void performASingleRandomMove()
	{
		Random r = new Random();

		if (r.nextBoolean())
		{
			if (r.nextBoolean())
			{
				if (monkey[0][2]==' ')
				{
					this.raiseLeftHand();
				}
				else
					this.lowerLeftHand();
			}
				
			else
			{
				if (monkey[0][0]==' ')
				{
					this.raiseRightHand();
				}
				else
					this.lowerRightHand();
			}
		}
		else
		{
			if (r.nextBoolean())
			{
				if (monkey[2][2]==' ')
				{
					this.lowerLeftLeg();
				}
				else
					this.raiseLeftLeg();
			}
				
			else
			{
				if (monkey[2][0]==' ')
				{
					this.lowerRightLeg();
				}
				else
					this.raiseRightLeg();
					
			}
		}
	}
}
