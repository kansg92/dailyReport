

const toDoForm = document.getElementById("todo-form");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.querySelector("#todo-list");

const TODOS_KEY = "todos"

let toDos = []; 

function saveToDos(){
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos)); //JSON.stringify() => 값을 모두 String으로 바꿔주는 함수
};

function deleteToDo(event){
    const li = event.target.parentElement; // click하였을때 나오는 버튼의 부모를 지정하여 준다.
    li.remove();
    toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id));
    saveToDos();
};

function paintToDo(newToDo){
    const li = document.createElement("li");
    li.id = newToDo.id;
    const span = document.createElement("span");
    span.innerText = newToDo.text;
    const button = document.createElement("button");
    button.classList = "todoButton"
    button.innerText = "x"
    const br = document.createElement("span");
    br.innerText = "\n";
    button.addEventListener("click", deleteToDo)  // 클릭하면 deleteToDo가 실행됨.
 
    li.appendChild(span);
    li.appendChild(button);
    li.appendChild(br);
    toDoList.appendChild(li);
};

function handelToDoSubmit(event){
    event.preventDefault();    
    const newToDo = toDoInput.value;
    toDoInput.value ="";  
    const newToDoObj = {
        text : newToDo,
        id : Date.now(),
    };
    toDos.push(newToDoObj);
    paintToDo(newToDoObj);
    saveToDos();
};

toDoForm.addEventListener("submit", handelToDoSubmit);

// function sayHello(item){
//     console.log("This is turn of", item)
// }

const savedToDos = localStorage.getItem(TODOS_KEY);
if(savedToDos !== null ){
    const parseToDos = JSON.parse(savedToDos);
    toDos = parseToDos;
    parseToDos.forEach(paintToDo);
};




function savesHabit(){

	
};









function changeToDo(event){
	const td = event.target;
	const input = event.target.querySelector('input');
	if(input.classList.contains("hidden2") && input.classList.contains("habit1")){
		input.classList.remove("hidden2");
		td.innerHTML = '<input type="text" name="habit1" id="habit1" class="habit1">';
	}
	if(input.classList.contains("hidden2") && input.classList.contains("habit2")){
		input.classList.remove("hidden2");
		td.innerHTML = '<input type="text" name="habit2" id="habit2" class="habit2">';
	}
	if(input.classList.contains("hidden2") && input.classList.contains("habit3")){
		input.classList.remove("hidden2");
		td.innerHTML = '<input type="text" name="habit3" id="habit3" class="habit3">';
	}
	if(input.classList.contains("hidden2") && input.classList.contains("habit4")){
		input.classList.remove("hidden2");
		td.innerHTML = '<input type="text" name="habit4" id="habit4" class="habit4">';
	}	
};

addEventListener("dblclick", changeToDo);

function enter(event){
			
		if(window.event.keyCode == 13){
			const input = event.target;
			if(input.value == ''){
				return;
			}else if(input.classList.contains("habit1")){
				localStorage.setItem("habit1",input.value)
				input.after(`${input.value}`);
				input.classList.add("hidden2");
			}else if(input.classList.contains("habit2") == true){
				localStorage.setItem("habit2",input.value)
				input.after(`${input.value}`);
				input.classList.add("hidden2");
			}else if(input.classList.contains("habit3") == true){
				localStorage.setItem("habit3",input.value)
				input.after(`${input.value}`);
				input.classList.add("hidden2");
			}else if(input.classList.contains("habit4") == true){
				localStorage.setItem("habit4",input.value)
				input.after(`${input.value}`);
				input.classList.add("hidden2");
			}
			
		}
	
}
addEventListener("keyup", enter);

const savedHabit1 = localStorage.getItem('habit1');
const savedHabit2 = localStorage.getItem('habit2');
const savedHabit3 = localStorage.getItem('habit3');
const savedHabit4 = localStorage.getItem('habit4');

$(document).ready(function(){
	if(savedHabit1 == null ){
		$('#habitCard1').html('<input type="text" name="habit1" id="habit1" class="habit1 hidden2">'+"더블클릭하여 수정하실 수 있습니다.")		
	}else{
		$('#habitCard1').html('<input type="text" name="habit1" id="habit1" class="habit1 hidden2">'+savedHabit1);
		
	}
	if(savedHabit2 == null ){
		$('#habitCard2').html('<input type="text" name="habit2" id="habit2" class="habit2 hidden2">'+"더블클릭하여 수정하실 수 있습니다.")		
	}else{
		$('#habitCard2').html('<input type="text" name="habit2" id="habit2" class="habit2 hidden2">'+savedHabit2);
		
	}
	if(savedHabit3 == null ){
		$('#habitCard3').html('<input type="text" name="habit2" id="habit2" class="habit3 hidden2">'+"더블클릭하여 수정하실 수 있습니다.")		
	}else{
		$('#habitCard3').html('<input type="text" name="habit2" id="habit2" class="habit3 hidden2">'+savedHabit3);
		
	}
	if(savedHabit4 == null ){
		$('#habitCard4').html('<input type="text" name="habit2" id="habit2" class="habit4 hidden2">'+"더블클릭하여 수정하실 수 있습니다.")		
	}else{
		$('#habitCard4').html('<input type="text" name="habit2" id="habit2" class="habit4 hidden2">'+savedHabit4);
	}
	
	
	$('#resetBtn').click(function(){

		$('#todo-list > li ').remove();
		toDos = [];
		saveToDos();
		
	});
	
	
	
});































