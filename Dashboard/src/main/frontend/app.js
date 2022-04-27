let barchart = new Chart(document.getElementById("bar-chart"), {
    type: 'bar',
    data: {
      datasets: [
        {
          label: "AxisLabel (Label)",
          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
          data: []
        }
      ]
    },
    options: {
      legend: { display: false },
      title: {
        display: true,
        text: 'some text'
      }
    }
});

let piechart = new Chart(document.getElementById("pie-chart"), {
    type: 'pie',
    data: {
      labels: ["Positive", "Negative", "Neutral"],
      datasets: [{
        label: "Population (millions)",
        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f"],
        data: []
      }]
    },
    options: {
      title: {
        display: true,
        text: 'Predicted world population (millions) in 2050'
      }
    }
});



async function fetchBarData() {    

    const url = new URL("http://localhost:8085/v1/getSongCount");
    const response = await fetch(url);
    const datapoints  = await response.json();
    console.log(datapoints);
    return datapoints;
};

fetchBarData().then(datapoints => {
  const songs = datapoints.map(
    function(index){ 
      return index.title
    })
  const count = datapoints.map(
    function(index) {
      return index.processed
    })
    barchart.data.labels = songs;
    barchart.data.datasets[0].data = count;
    barchart.update();

  });

async function fetchPieData() {

    const url = new URL("http://localhost:8085/v1/getSongSentiment");
    const obj = await (await fetch(url)).json();
    console.log(obj);
    const entries = Object.entries(obj);
    piechart.data.datasets[0].data.push(entries[0][1]);
    piechart.data.datasets[0].data.push(entries[1][1]);
    piechart.data.datasets[0].data.push(entries[2][1]);
    piechart.update();
};