
const themeButton = document.querySelector('.theme');
if (themeButton) {
  const applyTheme = (light) => {
    document.body.classList.toggle('light', light);
    themeButton.setAttribute('aria-pressed', String(light));
    themeButton.setAttribute('aria-label', light ? 'Ativar tema escuro' : 'Ativar tema claro');
  };
  try { applyTheme(localStorage.getItem('portfolio-theme') === 'light'); } catch (_) { /* Armazenamento opcional. */ }
  themeButton.hidden = false;
  themeButton.addEventListener('click', () => {
    const light = !document.body.classList.contains('light');
    applyTheme(light);
    try { localStorage.setItem('portfolio-theme', light ? 'light' : 'dark'); } catch (_) { /* Mantém o tema nesta visita. */ }
  });
}
