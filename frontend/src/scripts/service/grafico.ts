import Chart from "chart.js/auto";
import {ListaUser} from "../../data/ListaUser";

export class GraficosCandidatos {

  public static gerarGrafico(): object {
    const buscarCompetencias: any = {};


    // competencia counter
    ListaUser.candidatos.forEach(candidato => {
      candidato.competencias.forEach(competencia => {
        buscarCompetencias[competencia] ? buscarCompetencias[competencia]++ : buscarCompetencias[competencia] = 1;
      });
    });

    const CANVAS = document.getElementById('competenciasChart') as HTMLCanvasElement;
    if (!CANVAS) {
      throw new Error("Could not find Canva element.");
    }
    const COMPETENCIAS = Object.keys(buscarCompetencias);
    const DATA = Object.values(buscarCompetencias);



    const chart = new Chart(CANVAS, {
      type: 'bar',
      data: {
        labels: COMPETENCIAS,
        datasets: [{
          label: 'Candidatos por competência',
          data: DATA,
          backgroundColor: 'rgba(115,115,115,0.6)',
          borderColor: 'rgb(0,0,0)',
          borderWidth: 1,
          hoverBackgroundColor: '#789bb6',
        }]
      },
      options: {
        scales: {
          x: {
            ticks: {
              display: true,
              color: 'white'
            }
          },
          y: {
            beginAtZero: true,
            ticks: {
              display: true,
              color: 'white',
              stepSize: 1,
            }
          }
        },
        layout: {
          padding: {
            top: 15,
          }
        },
        plugins: {
          legend: {
            labels: {
              color: 'white'
            }
          }
        }
      }
    });

    return chart;
  }
}
