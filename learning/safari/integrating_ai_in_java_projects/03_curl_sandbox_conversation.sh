curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
  "model": "gpt-4o",
  "messages": [
    {
      "role": "system",
      "content": [
        {
          "type": "text",
          "text": "You are an expert travel agent."
        }
      ]
    },
    {
      "role": "user",
      "content": [
        {
          "type": "text",
          "text": "I have a day off comming soon. Please suggest some good activities in the Hartford, CT, area for a day trip."
        }
      ]
    },
    {
      "role": "assistant",
      "content": [
        {
          "type": "text",
          "text": "Absolutely, Hartford, CT, and its surroundings offer a variety of activities that make for an engaging day trip. Here are some suggestions:\n\n1. **Mark Twain House & Museum**: Start your day with a visit to the home of one of America'\''s most beloved authors, Mark Twain. The guided tour is not only informative but vividly brings to life Twain’s era.\n\n2. **Wadsworth Atheneum Museum of Art**: This is the oldest continuously operating public art museum in the United States, featuring a remarkable collection of European Baroque art, American art, and contemporary works.\n\n3. **Elizabeth Park Conservancy**: If you'\''re visiting in the warmer months, stroll through Elizabeth Park, famous for its stunning rose garden. It’s a great spot for a leisurely walk or a picnic.\n\n4. **Connecticut Science Center**: An enjoyable spot for people of all ages, the Connecticut Science Center offers hands-on exhibits about science and technology, along with a stunning view from its observation deck.\n\n5. **Bushnell Park**: Since it’s right in downtown Hartford, Bushnell Park is perfect for a walk. Don’t miss the historic carousel and the Soldiers and Sailors Memorial Arch.\n\n6. **Hartford Stage**: If you’re a theater enthusiast, check out what’s on at the Hartford Stage. They offer a mix of popular and lesser-known plays, often with innovative performances.\n\n7. **Riverfront Recapture**: For something outdoors, explore the trails and parks along the Connecticut River. There are options for walking, biking, or simply relaxing by the water.\n\n8. **Old State House**: Discover Connecticut’s history at the Old State House, where you can learn about its role in significant events and enjoy some intriguing exhibits.\n\n9. **Dining in West Hartford**: End your day with a meal at one of the many great restaurants in nearby West Hartford. The area is known for its diverse culinary scene.\n\n10. **Day Trip to Collinsville**: If you have a car, consider driving to Collinsville, a picturesque historic village known for its antiquing, kayaking, and the Collinsville Canoe & Kayak Store.\n\nThese activities should provide a fulfilling day, whether you'\''re keen on history, nature, art, or just seeking some relaxation. Enjoy your day off!"
        }
      ]
    },
    {
      "role": "user",
      "content": [
        {
          "type": "text",
          "text": "That'\''s good. I want something within 15 minutes of Marlborough, CT"
        }
      ]
    },
    {
      "role": "assistant",
      "content": [
        {
          "type": "text",
          "text": "If you’re looking for activities within approximately 15 minutes of Marlborough, CT, there are a few local gems and experiences you can explore:\n\n1. **Salmon River State Forest**: This area offers beautiful trails suitable for hiking and enjoying nature. The Comstock Covered Bridge is a picturesque spot, particularly lovely for photography enthusiasts.\n\n2. **Glastonbury Hills Country Club**: If you'\''re into golf, enjoy a round at this well-maintained golf course, which offers a pleasant experience for golfers of all skill levels.\n\n3. **Blackledge Falls**: Located in nearby Glastonbury, this spot features an easy hike to a charming waterfall, especially enjoyable during the spring when the water flow is strong.\n\n4. **Glastonbury Farm Fresh Market**: If your visit falls on a weekend in the warmer months, check out this fresh market for local produce, artisanal goods, and more.\n\n5. **Glastonbury Public Library**: If you enjoy reading or want a peaceful place to relax, the library offers a cozy spot with a lovely view of the surrounding scenery.\n\n6. **Belltown Hill Orchards**: Visit this local orchard for apple picking in the fall or berry picking in the summer. They also offer a farm store where you can purchase fresh produce and local products.\n\n7. **East Hampton'\''s Air Line State Park Trail**: Perfect for walking, cycling, or jogging, this trail follows the bed of the former airline railroad and offers a scenic view of the Connecticut countryside.\n\n8. **Portland West Golf Course**: Another option for golf lovers, this course provides a more casual and relaxed environment compared to larger courses.\n\nThese activities should provide a relaxing and enjoyable day close to Marlborough. Enjoy exploring the local scenery and attractions!"
        }
      ]
    }
  ],
  "temperature": 1,
  "max_tokens": 2048,
  "top_p": 1,
  "frequency_penalty": 0,
  "presence_penalty": 0,
  "response_format": {
    "type": "text"
  }
}'