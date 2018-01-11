let array = [];

window.addEventListener("load", () => {
  let btn_song = document.getElementById("btn_song");
  btn_song.addEventListener("click", addButton);
  loadPlayList();
});

function addButton() {
  let song = document.getElementById("song");
  let songName = song.value;

  if (songName == "") {
    alert("Please enter a song");
  } else {
    addSongToList(songName);
    saveSong(songName);
    song.value = "";
  }
}

function addSongToList(songName) {
  let list_songs = document.getElementById("list_songs");
  let li = document.createElement("li");
  li.setAttribute("class", "list-group-item");
  li.innerHTML = songName;
  list_songs.appendChild(li);
}

function saveSong(song) {
  array.push(song);
  localStorage.setItem("playlist", JSON.stringify(array));
}

function loadPlayList() {
  let myPlayList = JSON.parse(localStorage.getItem("playlist"));
  if (myPlayList != null) {
    console.log(myPlayList);
    myPlayList.forEach(song => {
      addSongToList(song);
    });
  } else {
    console.log("Lege lijst");
  }
}
