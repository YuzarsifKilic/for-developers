/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      margin: {
        '420px': '420px',
      }
    },
    fontFamily: {
      'quicksand': ['Quicksand', 'sans-serif'],
    }
  },
  plugins: [],
}

