window.addEventListener("load", ()=>{

    let btn_song = document.getElementById("btn_song");
    btn_song.addEventListener("click", addButton);
    loadPlayList();

});

function addButton() {

    let song = document.getElementById("song");
    let songName = song.value;    

    if(songName == ""){
        alert("Please enter a song");
    } else {
        let list_songs = document.getElementById("list_songs");
        let li = document.createElement("li");
        li.setAttribute("class", "list-group-item");
        li.innerHTML = songName;
        list_songs.appendChild(li);
        saveSong(songName);
        song.value = "";
    }
}

function saveSong(song){
    localStorage.setItem("song", song);
}


function loadPlayList(){
    return localStorage.getItem("song");
}