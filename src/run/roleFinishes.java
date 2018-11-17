package run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class roleFinishes {
	static String region = "na1";
	static String key = "RGAPI-aaee2434-a2ad-498e-a57a-f5062d30c70a";
	static String [] roleNames = {"TOP","JUNGLE","MID","DUO_SUPPORT\",\"lane\":\"BOTTOM","DUO_CARRY\",\"lane\":\"BOTTOM"};
	public static void main (String [] args)
	{
		PrintWriter outputStream=null;
		String [] regions = {"na1","kr","euw1","ru","bbr1","oc1","jp1","eun1","tr1","la1","la2"};
		int rs = regions.length;
		for(int sleepAtNight=0;sleepAtNight<rs;sleepAtNight++)
		{
			try
			{
				outputStream=new PrintWriter(new FileOutputStream("roles"+regions[sleepAtNight],true));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Goodbye Cruel World");
				System.exit(0);
			}
			region = regions[sleepAtNight];
			outputStream.println(region);
			outputStream.println("Top Jungle Mid Bot/Support Bot/Carry");
			String challenger = getRequest("https://"+region+".api.riotgames.com/lol/league/v3/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key="+key);
			String master = getRequest("https://"+region+".api.riotgames.com/lol/league/v3/masterleagues/by-queue/RANKED_SOLO_5x5?api_key="+key);
			String both = challenger+master;
			ArrayList <String> ids = addAllBetween("playerOrTeamId\":\"", "\",\"playerOrTeamName", both);
			int length = ids.size();
			String [] lps = new String[length];
			int [][] roles = new int[length][5];
			for(int i=0;i<length;i++)
			{
				//System.out.println(i);
				String id = ids.get(i);
				String summoner = getRequest("https://"+region+".api.riotgames.com/lol/league/v3/positions/by-summoner/"+id+"?api_key="+key);
				String points = between(summoner,"leaguePoints\":",",\"wins\"");
				lps[i] = points;
				String info = getRequest("https://"+region+".api.riotgames.com/lol/summoner/v3/summoners/"+id+"?api_key="+key);
				String accID = between(info,"accountId\":",",\"name");
				String history = getRequest("https://"+region+".api.riotgames.com/lol/match/v3/matchlists/by-account/"+accID+"?queue=420&api_key=RGAPI-aaee2434-a2ad-498e-a57a-f5062d30c70a");
				ArrayList <String> role = addAllBetween("\"role\":\"","\"}",history);
				int apparentlyNotAlways100GJRiot = role.size();
				for(int k=0;k<apparentlyNotAlways100GJRiot;k++)
				{
					String r = role.get(k);
					for(int j=0;j<5;j++)
					{
						if(r.contains(roleNames[j]))
						{
							roles[i][j]++;
						}
					}	
				}
			}
			int [] intlp = new int[length];
			for(int i=0;i<length;i++)
			{
				intlp[i]=Integer.parseInt(lps[i]);
			}
			for(int i=0;i<length;i++)
			{
				for(int j=i+1;j<length;j++)
				{
					if(intlp[j]>intlp[i])
					{
						int temp = intlp[j];
						intlp[j] = intlp[i];
						intlp[i] = temp;
						for(int k=0;k<5;k++)
						{
							int temp2 = roles[i][k];
							roles[i][k] = roles[j][k];
							roles[j][k] = temp2;
						}
					}
				}
			}
			int [] mostPlayed = new int [5];
			for(int i=0;i<length;i++)
			{
				int [] counters = new int [5];
				for(int j=0;j<5;j++)
				{
					counters[j] = roles[i][j];
				}
				int most = 0;
				int n = counters[0];
				for(int j=1;j<5;j++)
				{
					if(counters[j]>n)
					{
						n = counters[j];
						most = j;
					}
				}
				mostPlayed[most]++;
				for(int p=0;p<5;p++)
				{
					outputStream.print(mostPlayed[p]+" ");
				}
				outputStream.println();
			}
			outputStream.close();
		}
	}
	
	public static ArrayList addAllBetween(String before, String after, String in) {
		ArrayList <String> ids = new ArrayList();
		while(in.contains(before))
		{
			int b = in.indexOf(before);
			int a = in.indexOf(after);
			String add = in.substring(b+before.length(), a);
			ids.add(add);
			in = in.substring(a+1);
		}
		return ids;
	}

	public static String getRequest (String s)
	{
		try
		{
		 Thread.sleep(1200);
		 URL myurl = new URL(s);
		 HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
		 InputStream ins = con.getInputStream();
		 InputStreamReader isr = new InputStreamReader(ins);
		 BufferedReader in = new BufferedReader(isr);
		 String info;
		 String r="";
		 while ((info = in.readLine()) != null)
		 {
			 r=r+info;
		 }
		 return r;
		}catch(Exception e)
		{
			return "inactive";
		}
	}
	
	public static String between (String main, String before, String after)
	{
		try
		{
		int b = main.indexOf(before)+before.length();
		int e = main.indexOf(after);
		return main.substring(b,e);
		}catch(Exception wtf)
		{
			System.out.println(main);
		}
		return "trolled";
	}
}
