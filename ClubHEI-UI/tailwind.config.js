/** @type {import('tailwindcss').Config} */ 
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        'student-illustration': "url('./assets/bg.png')",
      },
    }
  },
  plugins: [],
}