export default (timestamp) => {
  const date = new Date(timestamp)
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const min = date.getMinutes()
  const sec = date.getSeconds()

  return `${year}.${month < 10 ? '0'+month : month}.${day < 10 ? '0'+day : day} ${hour < 10 ? '0'+hour : hour}:${min < 10 ? '0'+min : min}:${sec < 10 ? '0'+sec : sec}`
}
