package com.si.project.page;

public class BoardPageModule {
		
		public static String makePage(String pagename, int totalCnt, int cp, int listSize, int pageSize) {
			
			StringBuffer sb=new StringBuffer();
			
			int totalpage = (totalCnt / listSize) + 1;
			if (totalCnt % listSize == 0)//여기 수정해서 사이즈조절
				totalpage--;

			int userGroup = cp / pageSize; //사용자의 그룹값 위치
			if (cp % pageSize == 0)
				userGroup--;
		
			 	//꺽괄호 만들기
			 if (userGroup != 0) {
				 
				 sb.append("<a href='javascript:show(");
				 int temp=(userGroup - 1) * pageSize + pageSize;
				 sb.append(temp);
				 sb.append(")'>&lt;&lt;</a>");
			
			 }
			 	for (int i = (userGroup * pageSize) + 1; i <= (userGroup * pageSize) + pageSize; i++) {
			 		
			 		sb.append("&nbsp;&nbsp;<a href='javascript:show(");
			 		sb.append(i);
			 		sb.append(")'>");
			 		sb.append(i);
			 		sb.append("</a>&nbsp;&nbsp;");
			 
			 	if (i == totalpage) {
			 	break;
			 	}
			 }
			
			 if (userGroup != ((totalpage / pageSize) - (totalpage % pageSize == 0 ? 1 : 0))) {
				 
				 sb.append("<a href='javascript:show(");
				 int temp=(userGroup + 1) * pageSize + 1;
				 sb.append(temp);
				 sb.append(")'>&gt;&gt;</a>");
			 }
		
	return sb.toString();
			
		}

	}

