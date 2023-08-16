import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "davidmoralv@gmail.com";

pipeline{
	agent any
	stages {
		stage('Obtener Fuentes') {
		 	steps {
				 checkout([$class: 'GitSCM', branches: [[name: "main"]],
                                          doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
                                        [credentialsId: "davidmoralesv", url: "https://github.com/davidmoralesv/demoblazeScreenPlay.git"]
                                ]])
			}
		}
		stage('Ejecutar Pruebas') {
			steps {
				script {
					try {
						bat "gradle clean test  --tests \"runners.DemoBlazeRunner\" aggregate"
						echo 'Test Ejecutados sin Fallo'
						currentBuild.result = 'SUCCESS'
					}
					catch(ex) {
	    				echo 'Test Ejecutados con Fallo'
	    				currentBuild.result ='UNSTABLE'
					}
				}
			}
		}
		stage('Generar Evidencias') {
			steps {
				script {
				    try {
						bat " rename \"${WORKSPACE}\\target\\site\\serenity\" serenity_${timestamp}"
		                echo 'Backup de evidencias realizado con exito'

		                publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Evidencias', reportTitles: 'Evidencias Pruebas Regresion'])
						echo 'Reporte Html realizado con exito'
					}
					catch(e) {
						echo 'No se realizó el Backup de evidencias'
			    		publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity", reportFiles: 'index.html', reportName: 'Evidencias', reportTitles: 'Evidencias Pruebas Regresion'])
						echo 'Reporte Html realizado con exito'
						currentBuild.result='SUCCESS'
					}
				}
			}
		}
	}
}
