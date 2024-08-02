const customName = document.getElementById('customname');
const randomize = document.querySelector('.randomize');
const story = document.querySelector('.story');

// Create Function to return random value from array.
function randomValueFromArray(array){
  const random = Math.floor(Math.random()*array.length);
  return array[random];
}
