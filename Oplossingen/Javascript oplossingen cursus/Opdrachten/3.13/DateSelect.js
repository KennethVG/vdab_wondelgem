var months =[["januari",31],
             ["februari",28],
             ["march",31],
             ["april",30],
             ["mai",31],
             ["june",30],
             ["july",31],
             ["august",31],
             ["september",30],
             ["oktober",31],
             ["november",30],
             ["december",31]];

function updateMonth(days) {
   const month = document.getElementById("month");
   const index = month.selectedIndex;
   month.options.length = 0;
   let j = 0;
   for(let i = 0; i < months.length; i++) {
      const opt = document.createElement("option");
      opt.text = months[i][0];
      opt.value = i;
      if(months[i][1] < days) opt.disabled="disabled";
      month.options[j++] = opt;
   }
   month.selectedIndex = index;
}

function updateDay(days) {
   const day = document.getElementById("day");
   const index = day.selectedIndex;
   day.options.length = 0;
   for(let i = 0; i < days; i++) {
      const opt = document.createElement("option");
      opt.text = i+1;
      opt.value = i+1;
      day.options[i] = opt;
   }
   day.selectedIndex = index;
}

function monthChanged() {
   const i = this.options[sel.selectedIndex].value;
   updateDay(months[i][1]);
}

function dayChanged() {
   updateMonth(this.selectedIndex+1);
}

function init() {
   const daySelect = document.getElementById("day");
   const monthSelect = document.getElementById("month");
   
   daySelect.addEventListener("change", dayChanged);
   monthSelect.addEventListener("change", monthChanged);
   
   updateMonth(28);
   updateDay(31);
}

window.addEventListener("load", init);
