@echo off
cd /d "%~dp0"
where java >nul 2>&1
if errorlevel 1 (
  echo Instale Java 17 ou superior e tente novamente.
  pause
  exit /b 1
)
echo Aguarde iniciar e abra http://localhost:8080 no navegador.
echo Para encerrar, pressione Ctrl+C.
java -jar app/portfolio.jar
pause
