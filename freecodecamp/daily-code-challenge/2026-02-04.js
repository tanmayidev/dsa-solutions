function truncateText(text) {
  return (
    text.length <= 20 
    ? text
    : `${text.slice(0, 17) + '...'}`
  )
}
