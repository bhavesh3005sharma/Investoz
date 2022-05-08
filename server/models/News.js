const mongoose = require('mongoose');
const newsSchema = new mongoose.Schema({
    image: {
        type: String,
        required: true,
    },
    about: {
        type: String,
        required: true,
    },
    created: {
        type: Date,
        default: Date.now()
    }
})

module.exports = mongoose.model('News', newsSchema);