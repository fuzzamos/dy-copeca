#include<stdio.h>
//#include<conio.h>
#include<string.h>
#include<stdlib.h>
#ifdef LLBMC
#include <llbmc.h>
#else
//#include <klee/klee.h>
#endif
int main_function(int itffile_num, FILE *wtfinfile)
{
//------------------added for the input test file reading
	char itf1[10]={"input"};
    char itf2[10];
     //itoa (itffile_num,itf2,10);
   snprintf(itf2,10,"%d", itffile_num);
    char itf3[10]={".txt"};
    strcat(itf1,itf2);
    strcat(itf1,itf3);
    FILE *itf;
	itf = fopen(itf1, "r");
	//**************************************

signed int Cur_Vertical_Sep;
signed int High_Confidence;
signed int Two_of_Three_Reports_Valid;
signed int Own_Tracked_Alt;
signed int Own_Tracked_Alt_Rate;
signed int Other_Tracked_Alt;
signed int Alt_Layer_Value;
signed int Positive_RA_Alt_Thresh__0 ;
signed int Positive_RA_Alt_Thresh__1 ;
signed int Positive_RA_Alt_Thresh__2 ;
signed int Positive_RA_Alt_Thresh__3 ;
signed int Up_Separation;
signed int Down_Separation;
signed int Other_RAC;
signed int Other_Capability;
signed int Climb_Inhibit;

//------------for reading values
	char itfbuff1[255]; 
	fscanf(itf, "%s", itfbuff1);
	Cur_Vertical_Sep=atoi(itfbuff1);
//------------for reading values
	char itfbuff2[255]; 
	fscanf(itf, "%s", itfbuff2);
	High_Confidence=atoi(itfbuff2);
//------------for reading values
	char itfbuff3[255]; 
	fscanf(itf, "%s", itfbuff3);
	Two_of_Three_Reports_Valid=atoi(itfbuff3);
//------------for reading values
	char itfbuff4[255]; 
	fscanf(itf, "%s", itfbuff4);
	Own_Tracked_Alt=atoi(itfbuff4);
//------------for reading values
	char itfbuff5[255]; 
	fscanf(itf, "%s", itfbuff5);
	Own_Tracked_Alt_Rate=atoi(itfbuff5);
//------------for reading values
	char itfbuff6[255]; 
	fscanf(itf, "%s", itfbuff6);
	Other_Tracked_Alt=atoi(itfbuff6);
//------------for reading values
	char itfbuff7[255]; 
	fscanf(itf, "%s", itfbuff7);
	Alt_Layer_Value=atoi(itfbuff7);
//------------for reading values
	char itfbuff8[255]; 
	fscanf(itf, "%s", itfbuff8);
	Positive_RA_Alt_Thresh__0=atoi(itfbuff8);
//------------for reading values
	char itfbuff9[255]; 
	fscanf(itf, "%s", itfbuff9);
	Positive_RA_Alt_Thresh__1=atoi(itfbuff9);
//------------for reading values
	char itfbuff10[255]; 
	fscanf(itf, "%s", itfbuff10);
	Positive_RA_Alt_Thresh__2=atoi(itfbuff10);
//------------for reading values
	char itfbuff11[255]; 
	fscanf(itf, "%s", itfbuff11);
	Positive_RA_Alt_Thresh__3=atoi(itfbuff11);
//------------for reading values
	char itfbuff12[255]; 
	fscanf(itf, "%s", itfbuff12);
	Up_Separation=atoi(itfbuff12);
//------------for reading values
	char itfbuff13[255]; 
	fscanf(itf, "%s", itfbuff13);
	Down_Separation=atoi(itfbuff13);
//------------for reading values
	char itfbuff14[255]; 
	fscanf(itf, "%s", itfbuff14);
	Other_RAC=atoi(itfbuff14);
//------------for reading values
	char itfbuff15[255]; 
	fscanf(itf, "%s", itfbuff15);
	Other_Capability=atoi(itfbuff15);
//------------for reading values
	char itfbuff16[255]; 
	fscanf(itf, "%s", itfbuff16);
	Climb_Inhibit=atoi(itfbuff16);
  
  signed int enabled, tcas_equipped, intent_not_known;
  signed int need_upward_RA, need_downward_RA;
  signed int alt_sep;
  signed int alim;
  // New variables added ....
  signed int temp1,temp2,temp3,temp4;
  signed int result_Non_Crossing_Biased_Climb;
  signed int result_Non_Crossing_Biased_Descend;   
//------------for reading values
	char itfbuff17[255]; 
	fscanf(itf, "%s", itfbuff17);
	enabled=atoi(itfbuff17);
//------------for reading values
	char itfbuff18[255]; 
	fscanf(itf, "%s", itfbuff18);
	tcas_equipped=atoi(itfbuff18);
//------------for reading values
	char itfbuff19[255]; 
	fscanf(itf, "%s", itfbuff19);
	intent_not_known=atoi(itfbuff19);
//------------for reading values
	char itfbuff20[255]; 
	fscanf(itf, "%s", itfbuff20);
	need_upward_RA=atoi(itfbuff20);
//------------for reading values
	char itfbuff21[255]; 
	fscanf(itf, "%s", itfbuff21);
	need_downward_RA=atoi(itfbuff21);
//------------for reading values
	char itfbuff22[255]; 
	fscanf(itf, "%s", itfbuff22);
	alt_sep=atoi(itfbuff22);
//------------for reading values
	char itfbuff23[255]; 
	fscanf(itf, "%s", itfbuff23);
	alim=atoi(itfbuff23);
//------------for reading values
	char itfbuff24[255]; 
	fscanf(itf, "%s", itfbuff24);
	temp1=atoi(itfbuff24);
//------------for reading values
	char itfbuff25[255]; 
	fscanf(itf, "%s", itfbuff25);
	temp2=atoi(itfbuff25);
//------------for reading values
	char itfbuff26[255]; 
	fscanf(itf, "%s", itfbuff26);
	temp3=atoi(itfbuff26);
//------------for reading values
	char itfbuff27[255]; 
	fscanf(itf, "%s", itfbuff27);
	temp4=atoi(itfbuff27);
//------------for reading values
	char itfbuff28[255]; 
	fscanf(itf, "%s", itfbuff28);
	result_Non_Crossing_Biased_Climb=atoi(itfbuff28);
//------------for reading values
	char itfbuff29[255]; 
	fscanf(itf, "%s", itfbuff29);
	result_Non_Crossing_Biased_Descend=atoi(itfbuff29);

  // -- initialize();
  Positive_RA_Alt_Thresh__0 = 400;
  Positive_RA_Alt_Thresh__1 = 500;
  Positive_RA_Alt_Thresh__2 = 640;
  Positive_RA_Alt_Thresh__3 = 740;
  // -- alt_sep_test();
  
  enabled=0;
  tcas_equipped=0;
  intent_not_known=0;
  need_upward_RA=0;
  need_downward_RA=0;
      
  // -- -- alim = ALIM();
  if ( Alt_Layer_Value == 0 ){
    alim = Positive_RA_Alt_Thresh__0 ;
  }  
  if ( Alt_Layer_Value == 1 ){
    alim = Positive_RA_Alt_Thresh__1 ;
  }  
  if ( Alt_Layer_Value == 2 ){
    alim = Positive_RA_Alt_Thresh__2 ;
  }
  alim = Positive_RA_Alt_Thresh__3 ;
  

//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 1:( (High_Confidence !=0) && (Own_Tracked_Alt_Rate <= 600) && (Cur_Vertical_Sep > 600) )\n");
fprintf(wtfinfile,"%d,%d,%d,%d\n",( High_Confidence !=0 ),( Own_Tracked_Alt_Rate <= 600 ),( Cur_Vertical_Sep > 600 ),( (High_Confidence !=0) && (Own_Tracked_Alt_Rate <= 600) && (Cur_Vertical_Sep > 600) ));}
//----------------------------------------------------
  if ( (High_Confidence !=0) && (Own_Tracked_Alt_Rate <= 600) && (Cur_Vertical_Sep > 600) ){
    enabled = 1 ;
    
  }

  if ( Other_Capability == 0 ){
    tcas_equipped = 1 ;
        
  }
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 2:( (Two_of_Three_Reports_Valid !=0 ) && Other_RAC == 0 )\n");
fprintf(wtfinfile,"%d,%d,%d\n",( Two_of_Three_Reports_Valid !=0  ),( Other_RAC == 0 ),( (Two_of_Three_Reports_Valid !=0 ) && Other_RAC == 0 ));}
//----------------------------------------------------
  if ( (Two_of_Three_Reports_Valid !=0 ) && Other_RAC == 0 ){
    intent_not_known = 1 ;
    
  }
  alt_sep = 0;
  

//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 3:((enabled !=0)&& (((tcas_equipped !=0)&& (intent_not_known !=0))  || ! (tcas_equipped !=0)))\n");
fprintf(wtfinfile,"%d,%d,%d,%d,%d\n",(enabled !=0),( tcas_equipped !=0),( intent_not_known !=0  ),( ! tcas_equipped !=0),((enabled !=0)&& (((tcas_equipped !=0)&& (intent_not_known !=0))  || ! (tcas_equipped !=0))));}
//----------------------------------------------------
  if ((enabled !=0)&& (((tcas_equipped !=0)&& (intent_not_known !=0))  || ! (tcas_equipped !=0)))
    {
      //////////////////////////////////////////////////////////////////////////////
       { // ENTERING Non_Crossing_Biased_Climb();
	signed int upward_preferred_1;
	signed int alim_Non_Crossing_Biased_Climb;
	signed int temp11,temp12,temp13;

//------------for reading values
	char itfbuff30[255]; 
	fscanf(itf, "%s", itfbuff30);
	upward_preferred_1=atoi(itfbuff30);
//------------for reading values
	char itfbuff31[255]; 
	fscanf(itf, "%s", itfbuff31);
	alim_Non_Crossing_Biased_Climb=atoi(itfbuff31);
//------------for reading values
	char itfbuff32[255]; 
	fscanf(itf, "%s", itfbuff32);
	temp11=atoi(itfbuff32);
//------------for reading values
	char itfbuff33[255]; 
	fscanf(itf, "%s", itfbuff33);
	temp12=atoi(itfbuff33);
//------------for reading values
	char itfbuff34[255]; 
	fscanf(itf, "%s", itfbuff34);
	temp13=atoi(itfbuff34);

	upward_preferred_1 = 0 ;
	result_Non_Crossing_Biased_Climb=0;
	
	// alim = ALIM() ;
	if ( Alt_Layer_Value == 0 ){
	  alim_Non_Crossing_Biased_Climb =  Positive_RA_Alt_Thresh__0 ;
	  
	}  
	if ( Alt_Layer_Value == 1 ){
	  alim_Non_Crossing_Biased_Climb = Positive_RA_Alt_Thresh__1 ;
	  
	}  
	if ( Alt_Layer_Value == 2 ){
	  alim_Non_Crossing_Biased_Climb =  Positive_RA_Alt_Thresh__2 ;
	  
	}  
	alim_Non_Crossing_Biased_Climb =  Positive_RA_Alt_Thresh__3 ;
	

	// temp11 = Inhibit_Biased_Climb();
	if (Climb_Inhibit==1) {temp11= Up_Separation + 100; }
	else {temp11 = Up_Separation; }
	

	if (temp11 > Down_Separation ){
	  upward_preferred_1 = 1 ;
	  
	}  

	if (upward_preferred_1==1)
	  {
	    // temp12 = Own_Below_Threat();
	    if (Own_Tracked_Alt < Other_Tracked_Alt){
	      temp12 = 1 ;
	      
	    }else{
	      temp12 = 0 ;
	      
	    }  
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 4:( !(temp12 !=0 ) || ((temp12 !=0 )&& (!(Down_Separation >= alim_Non_Crossing_Biased_Climb))) )\n");
fprintf(wtfinfile,"%d,%d,%d,%d\n",( !temp12 !=0  ),( temp12 !=0 ),( !Down_Separation >= alim_Non_Crossing_Biased_Climb ),( !(temp12 !=0 ) || ((temp12 !=0 )&& (!(Down_Separation >= alim_Non_Crossing_Biased_Climb))) ));}
//----------------------------------------------------
	    if ( !(temp12 !=0 ) || ((temp12 !=0 )&& (!(Down_Separation >= alim_Non_Crossing_Biased_Climb))) ){
	      result_Non_Crossing_Biased_Climb = 1 ;
	      
	    }
	  }
	else
	  {
	    // temp13= Own_Above_Threat();
	    if (Other_Tracked_Alt < Own_Tracked_Alt){
	      temp13 =  1 ;
	      
	    }else{
	      temp13 = 0 ;
	      
	    }  
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 5:( (temp13 !=0 )  &&  (Cur_Vertical_Sep >= 300) && (Up_Separation >= alim_Non_Crossing_Biased_Climb) )\n");
fprintf(wtfinfile,"%d,%d,%d,%d\n",( temp13 !=0   ),(  Cur_Vertical_Sep >= 300 ),( Up_Separation >= alim_Non_Crossing_Biased_Climb ),( (temp13 !=0 )  &&  (Cur_Vertical_Sep >= 300) && (Up_Separation >= alim_Non_Crossing_Biased_Climb) ));}
//----------------------------------------------------
	    if ( (temp13 !=0 )  &&  (Cur_Vertical_Sep >= 300) && (Up_Separation >= alim_Non_Crossing_Biased_Climb) ){
	      result_Non_Crossing_Biased_Climb = 1 ;
	      
	    }  
	  }
      }  // LEAVING_NON_CROSSING_BIASED_CLIMB:
      //////////////////////////////////////////////////////////////////////////////
      temp1 = result_Non_Crossing_Biased_Climb;
      
      //  temp2 = Own_Below_Threat();
      if (Own_Tracked_Alt < Other_Tracked_Alt){
	temp2= 1 ;
	
      }else{
	temp2 = 0 ;
	
      }
	
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 6:( (temp1 !=0) && (temp2 !=0 ) )\n");
fprintf(wtfinfile,"%d,%d,%d\n",( temp1 !=0 ),( temp2 !=0  ),( (temp1 !=0) && (temp2 !=0 ) ));}
//----------------------------------------------------
      if ( (temp1 !=0) && (temp2 !=0 ) ){
	need_upward_RA = 1 ;
	
      }	

      //////////////////////////////////////////////////////////////////////////////
      // temp3 = Non_Crossing_Biased_Descend();
      //////////////////////////////////////////////////////////////////////////////
      {
	// ENTERING Non_Crossing_Biased_Descend()
	signed int upward_preferred_2;
	signed int alim_Non_Crossing_Biased_Descend;
	signed int temp21,temp22,temp23;
//------------for reading values
	char itfbuff35[255]; 
	fscanf(itf, "%s", itfbuff35);
	upward_preferred_2=atoi(itfbuff35);
//------------for reading values
	char itfbuff36[255]; 
	fscanf(itf, "%s", itfbuff36);
	alim_Non_Crossing_Biased_Descend=atoi(itfbuff36);
//------------for reading values
	char itfbuff37[255]; 
	fscanf(itf, "%s", itfbuff37);
	temp21=atoi(itfbuff37);
//------------for reading values
	char itfbuff38[255]; 
	fscanf(itf, "%s", itfbuff38);
	temp22=atoi(itfbuff38);
//------------for reading values
	char itfbuff39[255]; 
	fscanf(itf, "%s", itfbuff39);
	temp23=atoi(itfbuff39);
	
	upward_preferred_2 = 0 ;
	result_Non_Crossing_Biased_Descend = 0 ;
	

	// alim_Non_Crossing_Biased_Descend=ALIM() ;
	if ( Alt_Layer_Value == 0 ){
	  alim_Non_Crossing_Biased_Descend= Positive_RA_Alt_Thresh__0 ;
	  
	}  
	if ( Alt_Layer_Value == 1 ){
	  alim_Non_Crossing_Biased_Descend= Positive_RA_Alt_Thresh__1 ;
	  
	}  
	if ( Alt_Layer_Value == 2 ){
	  alim_Non_Crossing_Biased_Descend= Positive_RA_Alt_Thresh__2 ;
	    
	}  
	alim_Non_Crossing_Biased_Descend= Positive_RA_Alt_Thresh__3 ;
	
	
	// temp21 = Inhibit_Biased_Climb();
	if (Climb_Inhibit==1) {
	  temp21 = Up_Separation + 100;
	  
	}else{ 
	  temp21 = Up_Separation;
	  
	}  
	
	if ( temp21 > Down_Separation ){
	  upward_preferred_2 = 1 ;
	  
	}  
	if (upward_preferred_2 ==1)
	  {
	    // temp22 = Own_Below_Threat();
	        if (Own_Tracked_Alt < Other_Tracked_Alt){
		  temp22 = 1 ;
		}else{ temp22 = 0;}
		
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 7:((temp22 !=0 ) &&  (Cur_Vertical_Sep >= 300) && (Down_Separation >= alim_Non_Crossing_Biased_Descend) )\n");
fprintf(wtfinfile,"%d,%d,%d,%d\n",(temp22 !=0  ),(  Cur_Vertical_Sep >= 300 ),( Down_Separation >= alim_Non_Crossing_Biased_Descend ),((temp22 !=0 ) &&  (Cur_Vertical_Sep >= 300) && (Down_Separation >= alim_Non_Crossing_Biased_Descend) ));}
//----------------------------------------------------
		if((temp22 !=0 ) &&  (Cur_Vertical_Sep >= 300) && (Down_Separation >= alim_Non_Crossing_Biased_Descend) ){
	      result_Non_Crossing_Biased_Descend = 1 ;
	      
	      }
	  }
	else
	  {
	    // temp23 = Own_Above_Threat();
	    if (Other_Tracked_Alt < Own_Tracked_Alt){
	      temp23 = 1 ;
	    }else{
	      temp23 = 0 ;
	    }  
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 8:( !(temp23 !=0 ) || ((temp23 !=0 ) && (Up_Separation >= alim_Non_Crossing_Biased_Descend)))\n");
fprintf(wtfinfile,"%d,%d,%d,%d\n",( !temp23 !=0  ),( temp23 !=0  ),( Up_Separation >= alim_Non_Crossing_Biased_Descend),( !(temp23 !=0 ) || ((temp23 !=0 ) && (Up_Separation >= alim_Non_Crossing_Biased_Descend))));}
//----------------------------------------------------
	     if ( !(temp23 !=0 ) || ((temp23 !=0 ) && (Up_Separation >= alim_Non_Crossing_Biased_Descend))){
	      result_Non_Crossing_Biased_Descend = 1 ;
	      
	    }  
	  }
	
      } // ENTERING Non_Crossing_Biased_Descend()
      //////////////////////////////////////////////////////////////////////////////
      temp3= result_Non_Crossing_Biased_Descend;
      
      // temp4 = Own_Above_Threat();
      if (Other_Tracked_Alt < Own_Tracked_Alt){
	temp4 =  1 ;
      }else{ temp4 = 0 ;}
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 9:( (temp3 !=0 ) && (temp4 !=0 ) )\n");
fprintf(wtfinfile,"%d,%d,%d\n",( temp3 !=0  ),( temp4 !=0  ),( (temp3 !=0 ) && (temp4 !=0 ) ));}
//----------------------------------------------------
      if ( (temp3 !=0 ) && (temp4 !=0 ) ){
	need_downward_RA = 1 ;
      }	
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 10:((need_upward_RA !=0) && (need_downward_RA !=0 ))\n");
fprintf(wtfinfile,"%d,%d,%d\n",(need_upward_RA !=0 ),( need_downward_RA !=0 ),((need_upward_RA !=0) && (need_downward_RA !=0 )));}
//----------------------------------------------------
      if ((need_upward_RA !=0) && (need_downward_RA !=0 )){
	alt_sep = 0;
      }else if ((need_upward_RA !=0 )){
	alt_sep = 1;
      }else if ((need_downward_RA !=0 ))
        {
	  // BLAST/ARMC
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 11:( Up_Separation >= alim && Down_Separation < alim )\n");
fprintf(wtfinfile,"%d,%d,%d\n",( Up_Separation >= alim ),( Down_Separation < alim ),( Up_Separation >= alim && Down_Separation < alim ));}
//----------------------------------------------------
	  //if( Up_Separation >= alim && Down_Separation < alim ) 
	  //     ERROR: goto ERROR;
	  // TRACER
//------------Adding statements for printing-----------
{fprintf(wtfinfile,"%s","Predicate 12:( Up_Separation >= alim && Down_Separation < alim )\n");
fprintf(wtfinfile,"%d,%d,%d\n",( Up_Separation >= alim ),( Down_Separation < alim ),( Up_Separation >= alim && Down_Separation < alim ));}
//----------------------------------------------------
	  //_DECOMPILE_ABORT( Up_Separation >= alim && Down_Separation < alim );
	  alt_sep = 2;
	  
        }
        else{
	  alt_sep = 0;
	  
	}  
    }
  return 0;

}
int main(){
	FILE *fptr;
	int itfnos;
	int i=0;
	char filename[100]={".txt"};
	char completefilename[100];
	printf("Enter the file name to store the truth table:\n");
	scanf("%s", completefilename);
    strcat(completefilename,filename);
    fptr=fopen(completefilename,"w");
	printf("Enter the number of test data file:");
	scanf("%d",&itfnos);
	for(i=1;i<=itfnos;i++){
		fprintf(fptr,"%s%d%s","Test Case File Number is:",i,"\n");
		main_function(i,fptr);
	}
	return 0;
}
