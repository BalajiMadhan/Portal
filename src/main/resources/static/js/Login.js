function validateLogin(){

var userName=document.getElementById("uname").value;
var password=document.getElementById("pass").value;
$.ajax({
	url : "/LoginValidate/" + userName + "/" + password,
	success: function(data){
		
		if(data == 0){
			window.location="index.html"
		}
		if(data >= 0){
			window.location="menu.html"
		}
		
	},
	error: function(data){
		alert("error"+data)
	}


})

	
	
}

function profileData(){
	$("#filterListTable tr").remove();
	
	$.ajax({
		 type : "GET",
		 contentType : "application/json", 
		url : "/ProfileData",
		dataType : 'json',
      success : function(data) {
    	
    	  
    	  
    	  
    	var tr=[];
  		tr.push('<tr style="color:#009688;">');
  		tr.push("<th>Name</th>");
  		tr.push("<td>"+data.profileName+"</td>");
  		tr.push('</tr>');
  		
  		tr.push('<tr style="color:#009688;">');
  		tr.push("<th>Date of Birth</th>");
  		tr.push("<td>"+data.profileDOB+"</td>");
  		tr.push('</tr>');
  		
  		tr.push('<tr style="color:#009688;">');
  		tr.push("<th>Gender</th>");
  		tr.push("<td>"+data.profileGender+"</td>");
  		tr.push('</tr>');
  		
  		$.ajax({
  			 type : "GET",
  			 contentType : "application/json", 
  			url : "/userData",
  			dataType : 'json',
  			 success : function(data1) {
  		    	var tr=[];
  		  		tr.push('<tr style="color:#009688;">');
  		  		tr.push("<th>Username</th>");
  		  		tr.push("<td>"+data1.userName+"</td>");
  		  		tr.push('</tr>');
  		  		
  		  		tr.push('<tr style="color:#009688;">');
  		  		tr.push("<th>Password</th>");
  		  		tr.push("<td>"+data1.password+"</td>");
  		  		tr.push('</tr>');
  		  		
  		  	$('table[id=filterListTable]').append($(tr.join('')));
  		    	
  			 }
  		
  		})
  		
  		
  		$('table[id=filterListTable]').append($(tr.join('')));
  		
    	  
      }
     	 
	});
	
}



/*
function profile(){
	$("#filterListTable tr").remove();
	document.getElementById("content").innerHTML="<iframe src='profile.html' width='100%' height='400px'>"
}

function profileSubmit(){
	$("#filterListTable tr").remove();
	
	var pName=document.getElementById("name").value;
	var pDOB=document.getElementById("dob").value;
	var pGender=document.getElementById("gender");
	var genValue=pGender.elements["gender"].value
	
	 var profileJson = {"profileName" :pName, "profileDOB":pDOB, "profileGender":genValue };

  JSON.stringify(profileJson)
	
	
	$.ajax({
			 type : "POST",
			 contentType : "application/json",
			 url : "/ProfileCreation",
			 data : JSON.stringify(profileJson),
			 dataType : 'json',
	         success : function(data) { 
	         }

});
}
*/

function Training(){
	document.getElementById("content").innerHTML=" ";
	$("#filterListTable tr").remove();
	$.ajax({
			 type : "GET",
			 contentType : "application/json",
			 url : "/TrainingData",
			 dataType : 'json',
	         success : function(data) { 
	    	 
	    var tr=[];
		tr.push('<tr style="color:#009688;">');
	/*	tr.push("<th>Course Id</th>");*/
		tr.push("<th>Course Name</th>");
		tr.push("<th>Course Link</th>");
		tr.push("<th>Start  Date (yyyy-mm-dd)</th>");
		tr.push("<th>End  Date (yyyy-mm-dd)</th>");
		tr.push("<th>Status</th>");
		tr.push("<th>Update Status</th>");
		tr.push('</tr>');
   		 
				for (var i = 0; i < data.length; i++) {
					if(data[i].status == 0 || data[i].status == 1){
					tr.push('<tr">');
					/*tr.push("<td>"+data[i].courseID+"</td>");*/
					tr.push("<td>"+data[i].courseName+"</td>");
					tr.push("<td><a href='"+data[i].courseLink+"' >"+data[i].courseLink+"</a></td>");
					tr.push("<td>"+data[i].startDate+"</td>");
					tr.push("<td>"+data[i].endDate+"</td>");
					
					if(data[i].status == 0){
						tr.push("<td><input type='checkbox' name='courseStatus' id='courseStatus'></td>");
						tr.push("<td><input type='button' name='updateCourse' class='btn btn-primary' style='width:84%' id='updateCourse' class='btn btn-primary' onclick='updateCourse("+data[i].courseID+")' value='Update'/></td>");
					}
					if(data[i].status == 1){
						tr.push("<td><input type='checkbox' name='courseStatus' id='courseStatus' checked disabled></td>");
						tr.push("<td><input type='button' name='updateCourse' class='btn btn-primary' style='width:84%' id='updateCourse' onclick='updateCourse("+data[i].courseID+")' value='Completed' disabled /></td>");
					}
					
					
					
					tr.push('</tr>');
				}
				}
		$('table[id=filterListTable]').append($(tr.join('')));

	         }

});
}

function updateCourse(CourseId){
	
	
	$.ajax({
		 type : "GET",
		 contentType : "application/json",
		 url : "/StatusUpdate/" +CourseId,
		 dataType : 'json',
        success : function(data) {        	 
       	Training();
        }
        });
	
}

function certification(){
var	profileId=1;
$("#filterListTable tr").remove();
document.getElementById("content").innerHTML=" ";

	$.ajax({
		 type : "GET",
		 contentType : "application/json", 
		url : "/certification/" + profileId,
		dataType : 'json',
       success : function(data) { 
      	 
      	 

      		  var tr=[];
      		tr.push('<tr style="color:#009688;">');
      		tr.push("<th>Certification Name</th>");
      		tr.push("<th>Certification Date</th>");
      		tr.push("<th>Certification Expiry Date</th>");
      		tr.push('</tr>');
         		 
      				for (var i = 0; i < data.length; i++) {
      					
      					tr.push('<tr">');
      					tr.push("<td>"+data[i].certificationName+"</td>");
      					tr.push("<td>"+data[i].certificationstartDate+"</td>");
      					tr.push("<td>"+data[i].certificationendDate+"</td>");
      			
      				tr.push('</tr>');
      				
      				}
      				tr.push('<tr">');
  					tr.push("<td></td>");
  					tr.push("<td></td>");
  					tr.push("<td><input type='button' class='btn btn-primary' name='addCertification' data-toggle='modal' data-target='#myModal' id='addCertification'  value='Add'></td>");
  			
  				tr.push('</tr>');
  			
      		$('table[id=filterListTable]').append($(tr.join('')));

      		
      		
      	         }
       });
	
	
}



function UpdateCertification(){
	
	
	var certificationName=document.getElementById("cName").value;
	var certificationStart=document.getElementById("cStart").value;
	var certificationEnd=document.getElementById("cEnd").value;
	var CertificationJson = {"certificationName" :certificationName, "certificationstartDate":certificationStart, "certificationendDate":certificationEnd};
	
	

	

	$.ajax({
			 type : "POST",
			 contentType : "application/json",
			 url : "/CertificationUpdate",
			 data : JSON.stringify(CertificationJson),
			 dataType : 'json',
	         success : function(data) { 
	        	 certification();
	         }
});
	
}
function userNameDisplay(){
	
	$.ajax({
		 url : "/userNameDisplay",
        success : function(data) { 
       	 
       	 document.getElementById("NameDisplay").innerHTML="<h2>Welcome <label>"+data+"</label></h2>"
        }
});
	
}