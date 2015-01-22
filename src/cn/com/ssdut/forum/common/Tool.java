package cn.com.ssdut.forum.common;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.*;

public class Tool {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA);
	private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

	public static boolean processEmailAddress(Map<String, Object> emails) {
		try {
			String names = emails.get("names").toString();
			String addresses = emails.get("addresses").toString();
			// 二者不能为null，但是可以是空串
			
		
			names = names.trim();
			addresses = addresses.trim();

			StringBuffer smc = new StringBuffer(names);
			// 将逗号替换为分号
			// 处理smc
			for (int i = 0; i < smc.length(); i++) {
				if (smc.charAt(i) == ',') {
					smc.replace(i, i + 1, ";");

				}
			}
			ArrayList<String> al1 = new ArrayList<String>();
			ArrayList<String> al2 = new ArrayList<String>();

			ArrayList<String> al3 = new ArrayList<String>();
			ArrayList<String> al4 = new ArrayList<String>();

			ArrayList<String> al5 = new ArrayList<String>();
			ArrayList<String> al6 = new ArrayList<String>();

			names = smc.toString();
			addresses = addresses.trim();
			if (addresses.length() > 0) {
				String[] sa1 = addresses.split(",");
				for (String sa : sa1) {
					al1.add(sa);
				}
			}
			
			names = names.trim();

			if (names.length() > 0) {
				String[] sa2 = names.split(";");
				for (String sa : sa2) {
					al2.add(sa);
				}
			}

			// al1是地址，al2是名称
			int index = 0;
			for (String a1 : al1) {
				al3.add(a1); // al3是地址，al4是名称
				al4.add(al2.get(index));
				index++;
			}

			// 多余的邮件
			for (int i=index;i<al2.size();i++) {
				al3.add(al2.get(i));
				al4.add(al2.get(i));
			}

			// 处理，多余的名字，还有没有名字，只有邮件，还有空串,也可能都是空串，则放弃这个邮件

			for (int i = 0; i < al3.size(); i++) {
				String a1 = al3.get(i);
				String n1 = al4.get(i);
				a1 = a1.trim();
				n1 = n1.trim();
				if (a1.length() == 0) { // 没有地址，那么地址一定在名称中，需要取出名称，如果名称没有则取邮件地址@前的内容
					if (n1.indexOf('<') != -1) {
						a1 = n1.substring(n1.indexOf('<') + 1, n1.indexOf('>'));
					} else {
						if (n1.indexOf('@') != -1) {
							a1 = n1;
						} else {
							a1 = "";
						}
					}
				}
				
				if(a1.length()>0 && a1.indexOf('<')!=-1) {
					a1 = a1.substring(a1.indexOf('<') + 1, a1.indexOf('>'));
				}

				if (a1.length() > 0 && a1.indexOf('@') != -1) { // 合法的邮件地址
					al5.add(a1);
					// 现在处理名称
					n1 = n1.trim();
					if (n1.indexOf('<') != -1) {
						n1 = n1.substring(0, n1.indexOf('<'));
					}

					if (n1.indexOf('@') != -1) {
						n1 = n1.substring(0, n1.indexOf('@'));
					}

					if (n1.length() == 0) {
						n1 = a1.substring(0, a1.indexOf('@'));
					}

					al6.add(n1);

				}
			}
			
			//返回数据
			names = "";
			addresses = "";
			
			for(int i=0;i<al5.size();i++) {
				names = names + al6.get(i) + ";";
				addresses = addresses + al5.get(i) + ",";
			}
			
			if(names.length()>0) {
				names = names.substring(0,names.length()-1);
				
			}
			if(addresses.length()>0) {
				addresses = addresses.substring(0,addresses.length()-1);
				
			}
			
			
			emails.put("names", names);
			emails.put("addresses", addresses);

		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	public static String replace(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		Pattern CRLF = Pattern.compile("(\r\n|\n\r|\r|\n)");
		Matcher m = CRLF.matcher(s);

		if (m.find()) {
			return m.replaceAll("<br>");
		} else {
			return s;
		}

	}

	public static boolean validate(String dateString) {
		// 使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)
		Pattern p = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");
		Matcher m = p.matcher(dateString);
		if (!m.matches()) {
			return false;
		}

		// 得到年月日
		String[] array = dateString.split("-");
		int year = Integer.valueOf(array[0]);
		int month = Integer.valueOf(array[1]);
		int day = Integer.valueOf(array[2]);

		if (month < 1 || month > 12) {
			return false;
		}
		int[] monthLengths = new int[] { 0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) {
			monthLengths[2] = 29;
		} else {
			monthLengths[2] = 28;
		}
		int monthLength = monthLengths[month];
		if (day < 1 || day > monthLength) {
			return false;
		}
		return true;
	}

	/** 是否是闰年 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	public static String[] toIds(List<Map<String, Object>> ids, String id_key) {
		if (ids == null) {
			return null;
		} else {
			String[] s_ids = new String[ids.size()];
			int c = 0;
			for (Map<String, Object> id : ids) {
				s_ids[c] = id.get(id_key).toString();
				c++;
			}
			return s_ids;
		}
	}

	public static String[] toIds(Map<String, Object>[] ids, String id_key) {
		if (ids == null) {
			return null;
		} else {
			String[] s_ids = new String[ids.length];
			int c = 0;
			for (Map<String, Object> id : ids) {
				s_ids[c] = id.get(id_key).toString();
				c++;
			}
			return s_ids;
		}
	}

	public static String toDateString(long time) {
		java.util.Date d = new java.util.Date(time);

		return sdf.format(d);
	}

	public static String toDateString(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(d);
	}

	public static java.util.Date parseString(String date) {
		return sdf.parse(date, new ParsePosition(0));
	}

	public static java.sql.Date parseStringToSqlDate(String date) {
		java.util.Date d = sdf2.parse(date, new ParsePosition(0));
		return new java.sql.Date(d.getTime());
	}

	public static java.sql.Timestamp parseStringToSqlTimestamp(String dt) {
		try {
			Date dt2 = sdf.parse(dt);
			return new java.sql.Timestamp(dt2.getTime());
		} catch (Exception ex) {
			return null;
		}
	}

	public static java.sql.Timestamp parseStringToSqlTimestamp2(String dt) {
		try {
			Date dt2 = sdf4.parse(dt);
			return new java.sql.Timestamp(dt2.getTime());
		} catch (Exception ex) {
			return null;
		}
	}

	public static String toDatetimeString(java.sql.Timestamp dt) {
		return sdf.format(dt);
	}

	public static String convertToSize(long length) {
		if (length / 1024 < 1) {
			return "" + length + "B";
		} else if (length / 1024 / 1024 < 1) {
			double d = 1.0 * length / 1024;
			d = 1.0 * Math.round(d * 10) / 10;
			String sd = "" + d;
			int p = sd.indexOf(".");
			if (p != -1) {
				sd = sd.substring(0, p + 2);
			}
			return "" + sd + "KB";
		} else if (length / 1024 / 1024 / 1024 < 1) {
			double d = 1.0 * length / 1024 / 1024;
			d = 1.0 * Math.round(d * 10) / 10;
			String sd = "" + d;
			int p = sd.indexOf(".");
			if (p != -1) {
				sd = sd.substring(0, p + 2);
			}
			return "" + sd + "MB";
		} else if (length / 1024 / 1024 / 1024 / 1024 < 1) {
			double d = 1.0 * length / 1024 / 1024 / 1024;
			d = 1.0 * Math.round(d * 10) / 10;
			String sd = "" + d;
			int p = sd.indexOf(".");
			if (p != -1) {
				sd = sd.substring(0, p + 2);
			}
			return "" + sd + "GB";
		} else {
			double d = 1.0 * length / 1024 / 1024 / 1024 / 1024;
			d = 1.0 * Math.round(d * 10) / 10;
			String sd = "" + d;
			int p = sd.indexOf(".");
			if (p != -1) {
				sd = sd.substring(0, p + 2);
			}
			return "" + sd + "TB";
		}

	}

	public static String toScheduleDateString(java.util.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}

	
	
}
