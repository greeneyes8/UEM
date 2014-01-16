$(document).ready(function() {
//	alineamentoContainer();
//	$(documet).tooltip();
	alingDashBoard();
});

$(document).ready(function() {
	initDraggable();
	initCollapsable();
});

$(document).ready(function() {
	$(".box-header").css("width","+=10px");
	var conte=$("#contextPath").attr("value");
	$(".processing").children().attr("src",conte+"/res/img/spinner36_39.gif");
	$(".box").bind("click",function(){
		$(".box").css("z-index","2");
		$(this).css("z-index","3");
	});
});

function openPopUpWithAjaxContent(caseId,id){
	if(caseId.match("requested_course")){
		var conte=$("#context").attr("value");
		var ajax=sendAJAXmessage(conte+"/ajax/dialog/requested_course", "GET", "id", id);
		ajax.done(function(data){
			if($("#dialog").html()==undefined)
				$("<div></div>").attr('id','dialog').appendTo('body');
			$("#dialog").html(data);
		});
	}
}

function Commands(){
	// scrivere la classe che prende in input il set a command e poi con un to string ritorna la stringa come commando
}

function dialogModifyRequestedCourse(){
	$("#dialog").dialog({
		autoOpen : true,
		modal: true,
		width : "7aaaaaaaaaa5%",
		show : {
			effect : "blind",
			duration : 500
		},
		hide : {
			effect : "explode",
			duration : 500
		}
	});
	
	$("li[id^='modifyRequest']").bind("click", function(event) {
		var ids=this.id;
		ids=ids.replace("modifyRequest","");
		var id=ids.split("$")[0];
		var degree=ids.split("$")[1];
		alert("id is: "+id+" and degree is: "+degree);
		if($("#sendRequestCourseChange").html()==undefined){
//			$("<input></input>").attr('id','sendRequestCourseChange').attr('name','setCommand').appendTo('body');
			
		}
//			creare il div che apparirà d'avanti al mouse
		$("<div></div>")
		.attr('id','divRequestCourseChange')
		.appendTo('body').html($("#radio"+degree).html());
//			.css('height',"100px")
//			.css('left',event.pageX)
//			.css('top',event.pageY)
		$("#divRequestCourseChange").dialog({
		      resizable: false,
		      modal: true,
		      buttons: {
		        "Save": function() {
		          $( this ).dialog( "close" );
		          alert(ok);
//		          var newVal=$("input[name='choose']:radio:checked").val();
//		          requested_courseAddIfNotAddAlready ///strutturaaaa!!! classeEEEEE
//		          var comm="%requested"+id+"$change"+newVal+"%";
		          ok="no";
		          $("div").remove("#divRequestCourseChange");
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        	if($("#sendRequestCourseChange").val()==""){
		        		$("input").remove("#sendRequestCourseChange");
		        	}
		        	$("div").remove("#divRequestCourseChange");
		        }
		      }
		    });
		$("#setRequestCourseChange").css('height',"auto");
	});
}

function getDataFromAjax(item){
	var id=item.id;
	if(id.match("acourse")){
		var idCourse=id.replace("acourse","");
		var newId="divCourse"+idCourse;
		if($("#"+newId).html()==undefined){
			var conte=$("#context").attr("value");
			var ajax=sendAJAXmessage(conte+"/ajax/course/course_details", "GET", "idCourse", idCourse);
			ajax.done(function(data){
//				alert(data);
				var newDiv="<div id='"+newId+"'></div>";
				if($("#"+newId).html()==undefined)
					$(newDiv).insertAfter($(item));
				$("#"+newId).html(data);
			});
		}else{
			$("#"+newId).slideToggle(1000);
		}
	}
}
/**
 * <span class="span_expandible" id="collapseIDTAGTOCOLLAPSE">+</span>	
 */
function initCollapsable(){
	$("span[id^='collapse'],span[id^='expanse']").each(function() {
		$(this).bind("click", function() {
			var idOld = this.id;
//			alert(idOld+"");
			var realID;
			var newID;
			if(idOld.match("collapse")){
				realID = idOld.replace("collapse", "");
				newID="expanse";
				$(this).html("-");
			}else{
				realID = idOld.replace("expanse", "");
				newID="collapse";
				$(this).html("+");
			}
			var idd = realID;
			$("#" + idd).toggle();
			$(this).attr("id", newID+realID);
		});
	});
}

/**
 * <div> div da rendere draggable
 * <div>
 * <span class="lock-draggable-close" id="draggableIDTODRAG">lock/unlock</span>
 * </div>
 * </div>
 */
function initDraggable(){
	$("span[class^='lock']").bind("click",function(){
		if($(this).hasClass("lock-draggable-close")){
			$(this).removeClass("lock-draggable-close");
			$(this).addClass("lock-draggable-open");
			var idOld = this.id;
			var idTAG=idOld.replace("draggable","");
			$("#"+idTAG).addClass("draggable");
			$("#"+idTAG).draggable();
//			{
//			stop: function( event, ui ) {
//			changePersonalization(this,ui);
//			},
//			});
		}else{
			$(this).removeClass("lock-draggable-open");
			$(this).addClass("lock-draggable-close");
			var idOld = this.id;
			var idTAG=idOld.replace("draggable","");
			var tag=$("#"+idTAG);
			tag.removeClass("draggable");
			tag.draggable( "destroy" );
			changePersonalization(tag);
		}
	});
}


function alingDashBoard(){
	var count = $(".dashboard li").length;
	var percent=100/count;
	$(".dashboard li").css({"width":percent+"%"});
	$(".dashboard li").css({"text-align":"center"});
}	

function selectDashBoard(item){
	$(".dashboard > li.selected_dash_board").attr("class","");
	selectingFromDashBoard(item);
	var url=item.id.replace("Button","");
	window.location=$("#context").attr("value")+"/"+url;
}

function selectingFromDashBoard(element){
	element.parentNode.setAttribute("class","selected_dash_board");
}



function changePersonalization(item){
	//tramite ajax una richiesta che setta il div nella posizione lasciata
	var elementId=item.attr("id");
	var conte=$("#context").attr("value");
	conte=conte+"/personalizzation";
//	var formData = new FormData("caxx=cia&asd=ty");
	//idTAG:name=cicio%surname=pasticcio$idTAG:id=125
//	var dataSend=elementId+":[left#"+item.css("left")+"%top#"+item.css("top")+"]";
	//idTAG:name=cicio%surname=pasticcio$idTAG:id=125
	var dataSend=elementId+"[left:"+item.css("left")+",top:"+item.css("top");
//	var ajax=
	sendAJAXmessage(conte,"POST", "data", dataSend);
//	ajax.done(function(data){
//	alert(data+"");
//	});
}
////formData.append('cazz', "cio");
////formData=formData.serialize();
//var ing=$.ajax({
////beforeSend: function( xhr ) {
////xhr.overrideMimeType( "text/plain; charset=x-user-defined" );
////},
//type: "POST",
//url: conte+"/personalizzation",
////data: { 'name': "John", 'location': "Boston" },
//data:"data="+dataSend,
////contentType:"text; charset=utf-8",
////dataType:"text",
//processData:false
//});
////var ing=$.ajax({
////type: "POST",
////url: conte+"/personalizzation",
////processData: false,
////data: JSON.stringify(dataSend),
////contentType: "application/json",
////dataType:"json"
////});

//$(".processing").css("display","block");

//ing.done(function(msg){
//$(".processing").css("display","none");
//});
function sendAJAXmessage(url,type,name,value){
	var ing=$.ajax({
		type: type,
		url: url,
		data:name+"="+value,
		processData:false
	});
	$(".processing").css("display","block");
	ing.done(function(msg){
		$(".processing").css("display","none");
	});
	return ing;
}

function changeNote(item,idCourse){
	var idd=item.id;
//	alert($("#"+idd).children().html());
	var conte=$("#context").attr("value");
	conte=conte+"/changeNote";
	var dataSend=$("#"+idd).children().html();
	sendAJAXmessage(conte,"POST", "data"+idCourse, dataSend);
}


//removed trash
//$(window).bind("resize", resizeWindow);
//function resizeWindow(e) {
////alineamentoContainer();
//}
//function alineamentoContainer() {
//{
//alert("no");
//$(".container-left").css({"height":"auto"});
//$(".container-center").css({"height":"auto"});
////$(".container-right").css({"height":"auto"});
//$(".container-up").css({"height":"auto"});
//$(".container-down").css({"height":"auto"});

//var left = $(".container-left").css("height");
//var center = $(".container-center").css("height");
////var right = $(".container-right").css("height");

////alert("left : "+left+" center : "+center+" right: "+right);

//((left!=undefined)?left =parseInt(left.replace("px","")):left=0);
//((center!=undefined)?center =parseInt(center.replace("px","")):center=0);
////((right!=undefined)?right =parseInt(right.replace("px","")):right=0);

//if (left >= center) {
//$(".container-center").css({
//"height" : left
//});
//justContainer(left);
//} else if (center >= left) {
//$(".container-left").css({
//"height" : center
//});
//justContainer(center);
//}
//}
////container size
//}

//function justContainer(incr){
//var container=$("container").css("height");
//if(isNaN(container))
//container=0;
//else
//container=container.replace("px","");
//container=parseInt(container, 0);
//container=container+incr;
//incr=$(".container-up").css("height");
//((incr!=undefined)?incr =parseInt(incr.replace("px","")):incr=0);
//incr=parseInt(incr, 0);
//container=container+incr;
//incr=$(".container-down").css("height");
//((incr!=undefined)?incr =parseInt(incr.replace("px","")):incr=0);
//incr=parseInt(incr, 0);
//container=container+incr;
//container=container+20;
//$(".container").css({"height":container+"px"});
//}
