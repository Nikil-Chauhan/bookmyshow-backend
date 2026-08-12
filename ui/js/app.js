const movies=[
{id:1,title:"Dhurandhar",genre:"Action",language:"Hindi",duration:185,rating:8.7,description:"An action thriller about a covert mission, power and political conspiracy.",poster:"https://images.unsplash.com/photo-1485846234645-a62644f84728?auto=format&fit=crop&w=700&q=80"},
{id:2,title:"War 2",genre:"Action",language:"Hindi",duration:170,rating:8.2,description:"An elite spy faces a dangerous mission that changes everything.",poster:"https://images.unsplash.com/photo-1535016120720-40c646be5580?auto=format&fit=crop&w=700&q=80"},
{id:3,title:"Saiyaara",genre:"Romance",language:"Hindi",duration:155,rating:8.1,description:"A romantic musical drama about love, dreams and relationships.",poster:"https://images.unsplash.com/photo-1518391846015-55a9cc003b25?auto=format&fit=crop&w=700&q=80"},
{id:4,title:"Avatar: Fire and Ash",genre:"Adventure",language:"English",duration:192,rating:8.5,description:"Return to Pandora for another spectacular adventure.",poster:"https://images.unsplash.com/photo-1440404653325-ab127d49abc1?auto=format&fit=crop&w=700&q=80"},
{id:5,title:"Pushpa 2",genre:"Action",language:"Telugu",duration:200,rating:8.6,description:"Pushpa continues his journey against powerful enemies.",poster:"https://images.unsplash.com/photo-1500534623283-312aade485b7?auto=format&fit=crop&w=700&q=80"},
{id:6,title:"Interstellar",genre:"Adventure",language:"English",duration:169,rating:9.0,description:"A team travels through a wormhole in search of a future for humanity.",poster:"https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?auto=format&fit=crop&w=700&q=80"},
{id:7,title:"The Dark Knight",genre:"Action",language:"English",duration:152,rating:9.1,description:"Batman faces a criminal mastermind who plunges Gotham into chaos.",poster:"https://images.unsplash.com/photo-1531259683007-016a7b628fc3?auto=format&fit=crop&w=700&q=80"},
{id:8,title:"La La Land",genre:"Romance",language:"English",duration:128,rating:8.0,description:"A musician and an aspiring actress fall in love while chasing dreams.",poster:"https://images.unsplash.com/photo-1514525253161-7a46d19cd819?auto=format&fit=crop&w=700&q=80"}
];

const theaters=[
{name:"PVR Cinemas Meerut",address:"Shopprix Mall, Meerut",screen:"AUDI-1",times:["10:00 AM","2:00 PM","6:00 PM"],price:180},
{name:"INOX Meerut",address:"The Pacific Mall, Meerut",screen:"AUDI-1",times:["11:00 AM","3:00 PM","7:00 PM"],price:200},
{name:"PVR Select Citywalk",address:"Saket, New Delhi",screen:"AUDI-1",times:["11:00 AM","4:00 PM","8:00 PM"],price:250}
];

let selectedMovie=null, selectedShow=null, selectedSeats=[], bookings=JSON.parse(localStorage.getItem("bmsBookings")||"[]");

function $(id){return document.getElementById(id)}
function money(n){return "₹"+Number(n).toLocaleString("en-IN")}
function toast(msg){$("toast").textContent=msg;$("toast").classList.add("show");setTimeout(()=>$("toast").classList.remove("show"),2200)}

function movieCard(m){
return `<article class="movie-card"><img class="poster" src="${m.poster}" alt="${m.title}"><div class="movie-info"><h3>${m.title}</h3><div class="meta">${m.genre} • ${m.language} • ${m.duration} min</div><div class="rating">⭐ <b>${m.rating}</b>/10</div><button class="card-btn" onclick="showMovieDetails(${m.id})">Book Now</button></div></article>`;
}
function renderMovies(list=movies){$("homeMovies").innerHTML=list.slice(0,4).map(movieCard).join("");$("allMovies").innerHTML=list.map(movieCard).join("")}
function showPage(id){document.querySelectorAll(".page").forEach(p=>p.classList.remove("active"));$(id).classList.add("active");window.scrollTo(0,0)}
function showMovieDetails(id){
selectedMovie=movies.find(m=>m.id===id);
$("movieDetails").innerHTML=`<div class="details"><img class="poster" src="${selectedMovie.poster}" alt="${selectedMovie.title}"><div class="details-content"><p class="eyebrow">MOVIE</p><h1>${selectedMovie.title}</h1><p>⭐ ${selectedMovie.rating}/10 &nbsp; • &nbsp; ${selectedMovie.genre} &nbsp; • &nbsp; ${selectedMovie.language}</p><p>${selectedMovie.description}</p><p><b>Duration:</b> ${selectedMovie.duration} minutes</p><div class="show-box"><h3>Choose a show</h3>${theaters.map((t,i)=>`<div style="margin:20px 0"><b>${t.name}</b><small style="display:block;color:#aaa;margin:4px 0 10px">${t.address}</small><div class="show-row">${t.times.map(time=>`<button class="show-time" onclick="chooseShow(${i},'${time}')">${time} • ${money(t.price)}</button>`).join("")}</div></div>`).join("")}</div></div></div>`;
showPage("details");
}
function chooseShow(tIndex,time){
const t=theaters[tIndex];selectedShow={theater:t.name,address:t.address,screen:t.screen,time,price:t.price,date:new Date().toLocaleDateString("en-IN",{day:"2-digit",month:"short",year:"numeric"})};selectedSeats=[];renderSeats();$("showInfo").textContent=`${selectedMovie.title} • ${t.name} • ${time} • ${money(t.price)} per seat`;showPage("seats");
}
function renderSeats(){
let html="";const rows=["A","B","C","D","E","F"];let occupied=[3,8,14,22,27];
rows.forEach((r,ri)=>{html+=`<div class="seat-row"><span class="row-label">${r}</span>`;for(let c=1;c<=8;c++){let n=ri*8+c,occ=occupied.includes(n),sel=selectedSeats.includes(n);html+=`<button class="seat ${occ?"occupied":sel?"selected":"available"}" ${occ?"disabled":""} onclick="toggleSeat(${n},'${r}${c}')"></button>`}html+=`</div>`});$("seatMap").innerHTML=html;updateSeatSummary();
}
function toggleSeat(n,label){if(selectedSeats.includes(n)){selectedSeats=selectedSeats.filter(x=>x!==n)}else{if(selectedSeats.length>=8){toast("Maximum 8 seats per booking");return}selectedSeats.push(n)};renderSeats();window.selectedLabels=selectedSeats.map(n=>{let r=["A","B","C","D","E","F"][Math.floor((n-1)/8)];return r+((n-1)%8+1)})}
function updateSeatSummary(){let labels=selectedSeats.map(n=>{let r=["A","B","C","D","E","F"][Math.floor((n-1)/8)];return r+((n-1)%8+1)});$("selectedSeats").textContent=labels.length?labels.join(", "):"None";$("seatTotal").textContent=money(labels.length*(selectedShow?.price||0))}
$("checkoutBtn").onclick=()=>{if(!selectedSeats.length){toast("Please select at least one seat");return}renderCheckout();showPage("checkout")}
function renderCheckout(){let labels=selectedSeats.map(n=>{let r=["A","B","C","D","E","F"][Math.floor((n-1)/8)];return r+((n-1)%8+1)}),subtotal=labels.length*selectedShow.price,fee=Math.round(subtotal*.08),total=subtotal+fee;$("checkoutContent").innerHTML=`<h2>${selectedMovie.title}</h2><div class="summary-line"><span>Theater</span><b>${selectedShow.theater}</b></div><div class="summary-line"><span>Date & Time</span><b>${selectedShow.date} • ${selectedShow.time}</b></div><div class="summary-line"><span>Seats</span><b>${labels.join(", ")}</b></div><div class="summary-line"><span>Tickets</span><b>${labels.length} × ${money(selectedShow.price)}</b></div><div class="summary-line"><span>Convenience Fee</span><b>${money(fee)}</b></div><div class="summary-total"><span>Total</span><span>${money(total)}</span></div><button class="primary" style="width:100%;margin-top:25px" onclick="confirmBooking()">Confirm Booking</button>`}
function confirmBooking(){let labels=selectedSeats.map(n=>{let r=["A","B","C","D","E","F"][Math.floor((n-1)/8)];return r+((n-1)%8+1)}),subtotal=labels.length*selectedShow.price,fee=Math.round(subtotal*.08),booking={id:"BMS"+Date.now().toString().slice(-6),movie:selectedMovie.title,poster:selectedMovie.poster,theater:selectedShow.theater,date:selectedShow.date,time:selectedShow.time,seats:labels,total:subtotal+fee,status:"CONFIRMED"};bookings.unshift(booking);localStorage.setItem("bmsBookings",JSON.stringify(bookings));$("ticket").innerHTML=`<b>Booking ID:</b> ${booking.id}<br><br><b>${booking.movie}</b><br>${booking.theater}<br>${booking.date} • ${booking.time}<br><b>Seats:</b> ${booking.seats.join(", ")}<br><br><b>Total: ${money(booking.total)}</b>`;showPage("success")}
function renderBookings(){if(!bookings.length){$("bookingList").innerHTML=`<div class="success-card"><h2>No bookings yet</h2><p>Book your first movie to see it here.</p><a href="#movies" class="primary button-link">Browse Movies</a></div>`;return}$("bookingList").innerHTML=bookings.map(b=>`<div class="booking-item"><div><h3>${b.movie}</h3><p>${b.theater}<br>${b.date} • ${b.time}<br>Seats: ${b.seats.join(", ")}</p></div><div style="text-align:right"><div class="status">✓ ${b.status}</div><h3>${money(b.total)}</h3><small>${b.id}</small></div></div>`).join("")}
$("searchInput").addEventListener("input",e=>{let q=e.target.value.toLowerCase();let result=movies.filter(m=>m.title.toLowerCase().includes(q)||m.genre.toLowerCase().includes(q));if(location.hash!=="#movies")location.hash="#movies";renderMovies(result)})
document.querySelectorAll(".filter").forEach(btn=>btn.addEventListener("click",()=>{document.querySelectorAll(".filter").forEach(x=>x.classList.remove("active"));btn.classList.add("active");let f=btn.dataset.filter;renderMovies(f==="all"?movies:movies.filter(m=>m.genre===f))}))
$("loginBtn").onclick=()=>showPage("login");
$("loginForm").onsubmit=e=>{e.preventDefault();toast("Signed in successfully");location.hash="#home"}
$("registerForm").onsubmit=e=>{e.preventDefault();toast("Account created successfully");location.hash="#home"}
function route(){let id=location.hash.replace("#","")||"home";if(id==="movies"){renderMovies()}if(id==="bookings"){renderBookings()}if(["home","movies","details","seats","checkout","success","bookings","login","register"].includes(id))showPage(id)}
window.addEventListener("hashchange",route);renderMovies();route();
